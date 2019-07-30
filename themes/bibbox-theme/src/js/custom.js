$('.lexicon-icon-search').click(function(e) {
    if($('#wrapper>header>.row>.navbar-collapse .navbar-form[role=search] .input-text-wrapper input').val() == '') {
        e.stopPropagation();
        e.preventDefault();

        $('#wrapper>header>.row>.navbar-collapse .navbar-form[role=search] .input-text-wrapper').toggle(500);
    }
});

$('#wrapper > header .navbar-toggle').click(function(e) {
    $('#wrapper>header #navigationCollapse').slideToggle(500);
});