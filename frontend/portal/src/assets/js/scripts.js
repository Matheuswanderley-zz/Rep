$(document).ready(function(){
  $('.carousel.carousel-slider').carousel({fullWidth: true});
  $(".button-collapse").sideNav();
  $('.modal').modal();
  $('select').material_select();
  $('.tooltipped').tooltip({delay: 50});

  // $('.money').maskMoney({prefix:'R$ ', allowNegative: false, thousands:'.', decimal:',', affixesStay: true});


  $("#quartos").dpNumberPicker({
    min: 0, // Minimum value.
    max: 20, // Maximum value.
    value: 0, // Initial value
    step: 1, // Incremental/decremental step on up/down change.
    format: false,
    editable: true,
    addText: "+",
    subText: "-"
  });

  $("#suites").dpNumberPicker({
    min: 0, // Minimum value.
    max: 20, // Maximum value.
    value: 0, // Initial value
    step: 1, // Incremental/decremental step on up/down change.
    format: false,
    editable: true,
    addText: "+",
    subText: "-"
  });

  $("#banheiros").dpNumberPicker({
    min: 0, // Minimum value.
    max: 20, // Maximum value.
    value: 0, // Initial value
    step: 1, // Incremental/decremental step on up/down change.
    format: false,
    editable: true,
    addText: "+",
    subText: "-"
  });

  $("#vagas").dpNumberPicker({
    min: 0, // Minimum value.
    max: 20, // Maximum value.
    value: 0, // Initial value
    step: 1, // Incremental/decremental step on up/down change.
    format: false,
    editable: true,
    addText: "+",
    subText: "-"
  });

  $(".menu.sub").mouseleave(function() {
    $(".menu.sub").removeClass("active");
    $(".btn-menu").blur();
  });

  function sticky_relocate() {
    try {
      var window_top = $(window).scrollTop();
      var div_top = $('.sticky-anchor').offset().top;
      if (window_top > div_top) {
        $('.sticky').addClass('stick');
        $('.sticky-anchor').height($('.sticky').outerHeight());
      } else {
        $('.sticky').removeClass('stick');
        $('.sticky-anchor').height(0);
      }
    } catch(e) {}
  }

  $(window).scroll(sticky_relocate);
  sticky_relocate();

});

