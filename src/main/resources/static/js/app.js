(function () {
  /* Filtro e busca na lista de atividades */
  var lista = document.getElementById('lista');
  if (lista) {
    var linhas = Array.from(lista.querySelectorAll('.row'));
    var botoes = Array.from(document.querySelectorAll('.filters button'));
    var busca  = document.getElementById('busca');
    var contagem = document.getElementById('contagem');
    var vazio    = document.getElementById('vazio');
    var filtro   = 'todas';
    var norm = function (s) {
      return s.toLowerCase().normalize('NFD').replace(/[̀-ͯ]/g, '');
    };
    var aplicar = function () {
      var termo = norm(busca.value.trim()), n = 0;
      linhas.forEach(function (l) {
        var ok = (filtro === 'todas' || l.dataset.disc === filtro) &&
                 norm(l.textContent).indexOf(termo) > -1;
        l.hidden = !ok;
        if (ok) n++;
      });
      contagem.textContent = n + (n === 1 ? ' atividade' : ' atividades');
      vazio.hidden = n > 0;
    };
    botoes.forEach(function (b) {
      b.addEventListener('click', function () {
        filtro = b.dataset.f;
        botoes.forEach(function (x) { x.setAttribute('aria-pressed', String(x === b)); });
        aplicar();
      });
    });
    busca.addEventListener('input', aplicar);
    aplicar();
  }

  /* Avaliação — POST para o Spring controller via fetch */
  var form = document.getElementById('aval');
  if (form) {
    var msg = document.getElementById('msg');
    form.addEventListener('submit', function (e) {
      e.preventDefault();
      var dados = {}, falta = false;
      for (var i = 0; i < 4; i++) {
        var c = form.querySelector('input[name=q' + i + ']:checked');
        if (c) dados['q' + i] = c.value;
        else falta = true;
      }
      msg.className = 'msg';
      if (falta) {
        msg.className = 'msg erro';
        msg.textContent = 'Responda as quatro perguntas para enviar.';
        return;
      }
      var slug = form.dataset.slug;
      var btn  = form.querySelector('button[type=submit]');
      btn.disabled = true;

      var params = new URLSearchParams(dados);
      fetch('/avaliacao/' + slug, {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: params.toString()
      })
        .then(function (r) { return r.json(); })
        .then(function (data) {
          if (data.erro) {
            msg.className = 'msg erro';
            msg.textContent = data.erro;
            btn.disabled = false;
          } else {
            msg.textContent = data.mensagem || 'Avaliação enviada. Obrigado!';
          }
        })
        .catch(function () {
          msg.className = 'msg erro';
          msg.textContent = 'Erro ao enviar. Tente novamente.';
          btn.disabled = false;
        });
    });
  }
})();
