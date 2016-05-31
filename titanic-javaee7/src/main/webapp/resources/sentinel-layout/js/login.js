$(function() {
    var loginBox = $('#login-box');
    if(loginBox.length) {
        var tabHeaders = loginBox.find('.TabBtn'),
        tabContents = loginBox.find('.TabContent');
        
        tabHeaders.on('click', function(e) {
            tabHeaders.removeClass('TabBtnActiveLeft TabBtnActiveRight');
            tabContents.addClass('DispNone');

            if($(this).hasClass('left')) {
                $(this).addClass('TabBtnActiveLeft');
                $('#TAB' + $(this).attr('role')).removeClass('DispNone');
            } else {
                $(this).addClass('TabBtnActiveRight');
                $('#TAB' + $(this).attr('role')).removeClass('DispNone');
            }

            e.preventDefault();
        });
    } 
});