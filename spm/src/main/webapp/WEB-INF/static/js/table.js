$('tr:even').addClass('tr_even');
$('tr:odd').addClass('tr_odd');
$('tr').mouseover(function () {
    $(this).addClass('tr_hover');
}).mouseout(function () {
    $(this).removeClass('tr_hover');
});