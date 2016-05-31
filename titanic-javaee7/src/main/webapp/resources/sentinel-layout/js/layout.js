var Sentinel = {
    
    init: function() {
        this.menubar = this.menubar||$('#layout-menubar');
        this.menubarElement = this.menubar.get(0);
        this.menubarContainer = this.menubarContainer||this.menubar.children('ul.layout-menubar-container');
        this.content = $('#layout-portlets-cover');
        this.topMenu = $('#sm-topmenu');
        this.topMenuItems = this.topMenu.children('li');
        this.focusedItem = null;
        this.focusedTopItem = null;
        
        for(var i = 0; i < this.topMenuItems.length; i++) {
            var topItem = this.topMenuItems.eq(i);
            topItem.attr('tabindex', '0');
        }
        
        this.bindEvents();
        this.bindKeyEvents();
    },
            
    initTopMenu: function() {
        var $this = this;

        this.topMenuItems.on('mouseenter', function() {
            if($(window).width() < 640) {
                return;
            }
            
            if($this.topMenuHideTimeout) {
                clearTimeout($this.topMenuHideTimeout);
            }

            var item = $(this);
            if($this.activeTopMenuItem && $this.activeTopMenuItem.get(0) !== item.get(0)) {
                $this.hideTopMenuItem($this.activeTopMenuItem);
            }

            $this.activeTopMenuItem = item;
            item.children('ul').show();
        })
        .on('mouseleave', function() {
            if($(window).width() < 640) {
                return;
            }
            
            var item = $(this);
            $this.topMenuHideTimeout = setTimeout(function() {
                $this.hideTopMenuItem(item);
                $this.activeTopMenuItem = null;
            }, 1000);
        })
        .on('click', function() {
            var item = $(this);
            if($(window).width() <= 640) {
                if(item.hasClass('active-topmenuitem') && item.children('ul').is(':visible')) {
                    item.removeClass('active-topmenuitem').children('ul').css('display', 'none');
                }
                else {
                    item.addClass('active-topmenuitem').siblings('.active-topmenuitem').removeClass('active-topmenuitem').children('ul').hide();
                    item.children('ul').css('display', 'block');
                }
            }
            else {
                item.children('ul').toggle();
            }
        }).on('focus', function() {
            if($this.focusedTopItem) {
                var itemChildren = $this.focusedTopItem.children('ul');
                if(itemChildren.length && itemChildren.is(':visible')) {
                    itemChildren.hide();
                }
            }
            $this.focusedTopItem = $(this); 
        }).on('keydown', function(e){ 
            var keyCode = $.ui.keyCode,
                key = e.which;
            
            if((key === keyCode.ENTER)|| (key === keyCode.NUMPAD_ENTER) || (key === keyCode.SPACE)) {
                var childrenItem = $(this).children('ul');
                if(childrenItem.length) {
                    childrenItem.toggle();
                }
            }
        });
    },
    
    hideTopMenuItem: function(item) {
        item.children('ul').hide();
    },
            
    toggleLeftMenu: function() {
        if(this.menubar.hasClass('slimmenu')) {
            this.menubar.removeClass('slimmenu');
            $('#searchArea').removeClass('slimsearch');
            $.cookie('sentinel_menumode', 'large', {path:'/'});
        }
        else {
            this.menubar.addClass('slimmenu').removeClass('layout-menubar-open-fullscr');
            $('#searchArea').addClass('slimsearch');
            $.cookie('sentinel_menumode', 'slim', {path:'/'});
        }
        
        this.menubar.addClass('OvHidden').scrollTop(0).removeClass('OvHidden');
        $('body').removeClass('OvHidden'); 
    },
    
    bindEvents: function() {
        this.initTopMenu(); 
        
        var $this = this;
        
        //menubar resize btn binding
        $('#layout-menubar-resize').on('click', function(e) {
            Sentinel.toggleLeftMenu();
            e.preventDefault();
        });

        // responsive mode menubar open button
        $('#layout-menubar-resize2').on('click', function(e) {
            if($this.menubar.hasClass('layout-menubar-open-fullscr')) {
                $this.menubar.removeClass('layout-menubar-open-fullscr');
                $('body').removeClass('OvHidden');
            }
            else {
                $this.menubar.addClass('layout-menubar-open-fullscr').removeClass('slimmenu');
                $('#searchArea').removeClass('slimsearch');
                $('body').addClass('OvHidden');
            }
            
            e.preventDefault();
        });

        // responsive mode header bar open menus binding
        $('#sm-mobiletopmenu').on('click', function() {
            if($('#sm-topmenu').is(':visible')) {
                $('#sm-topmenu').removeClass('DispBlock');
            }
            else {
                $('#sm-topmenu').addClass('DispBlock');              
            }
        });
        
        //remove transitions on IOS
        if(this.isIOS()) {
            this.menubar.find('a').addClass('notransition');
        }
        
        //workaround for firefox bug of not resetting scrolltop
        if(navigator.userAgent.toLowerCase().indexOf('firefox') > -1) {
            $(window).on('resize', function() {
                $this.menubarElement.scrollTop = 0;
            });
        }
    },
    
    bindKeyEvents: function() {
        var $this = this;
        
        //keyboard events for ButtonArea on Left Menu
        $('#buttonArea').children('a').on('focus', function() {
            if($(this).is(':visible')) {
                $this.focusedItem = $(this);
            }
            
            if($this.focusedTopItem) {
                $this.hideTopMenuItem($this.focusedTopItem);
                $this.focusedTopItem = null;
            }
        });
        
        //keyboard events for menu container on Left Menu
        this.menubarContainer.find('a').on('focus', function() {
            $this.focusedItem = $(this);
        })
        .on('keydown', function(e){ 
            if(!$this.focusedItem) {
                return;
            }
            
            var keyCode = $.ui.keyCode;
            
            switch(e.which) {
                case keyCode.LEFT:
                    var currentSubMenu = $this.focusedItem.next();
                    if(currentSubMenu.length && currentSubMenu.is(':visible')) {
                        $this.toggleSubMenu(this);
                    }
                break;
                
                case keyCode.RIGHT: 
                    var currentSubMenu = $this.focusedItem.next(); 
                    if(currentSubMenu.length && currentSubMenu.is(':visible')) {   
                        $this.toggleSubMenu(this);
                    }
                break;
            }
        });        
    },
    
    //backward compatibilitys
    openSubMenu: function(element) {
        this.toggleSubMenu(element);
    },
            
    toggleSubMenu: function(element) {
        var link = $(element),
        menuitem = link.closest('li'),
        subMenuContainer = menuitem.children('ul.layout-menubar-submenu-container'),
        isRootItem = menuitem.parent().is(this.menubarContainer);

        if(isRootItem) {
            this.menubarContainer.find('> li.layout-menubar-active').removeClass('layout-menubar-active');
            menuitem.addClass('layout-menubar-active');
        }

        if(subMenuContainer.length) {
            if(subMenuContainer.is(':visible')) {
                subMenuContainer.hide();
                
                if(isRootItem) {
                    menuitem.removeClass('layout-menubar-active');
                    this.activeMenuitemId = undefined;
                    $.removeCookie('sentinel_activemenuitem', {path:'/'});
                }
                else {
                    this.activeMenuitemId = menuitem.closest('ul').parent().attr('id');
                    this.saveMenuState();
                }
            }
            else {
                subMenuContainer.slideDown(300);
                if(this.menubar.width() > 50 || isRootItem) {
                    menuitem.siblings().find('ul:visible').slideUp(300);
                }
                
                this.activeMenuitemId = menuitem.attr('id');
                this.saveMenuState();
            }
        }
        else {
            this.activeMenuitemId = menuitem.attr('id');
            this.saveMenuState();
        }
    },

    toggleCodes: function(on) {
        var obj = document.getElementById('icons');

        if (on) {
            obj.className += ' codesOn';
        } else {
            obj.className = obj.className.replace(' codesOn', '');
        }
    },
            
    restoreMenuState: function() {
        this.activeMenuitemId = $.cookie('sentinel_activemenuitem');
        this.menubar = $('#layout-menubar');
        this.menubarContainer = this.menubar.children('ul.layout-menubar-container');
                
        if($.cookie('sentinel_menumode') === 'slim') {
            this.menubar.addClass('slimmenu');
            $('#searchArea').addClass('slimsearch');
        }

        if(this.activeMenuitemId) {
            this.menubarContainer.find('> li.layout-menubar-active').removeClass('layout-menubar-active');
            this.restoreMenuitem($(document.getElementById(this.activeMenuitemId)));
        }
    },
    
    restoreMenuitem: function(menuitem) {
        var subMenuContainer = menuitem.children('ul.layout-menubar-submenu-container');
    
        subMenuContainer.show();
        
        if(menuitem.parent().hasClass('layout-menubar-submenu-container')) {
            this.restoreMenuitem(menuitem.parent().parent());
        }
        else {
            menuitem.addClass('layout-menubar-active');
        }
    },
    
    saveMenuState: function() {
        $.cookie('sentinel_activemenuitem', this.activeMenuitemId, {path:'/'});
        $.cookie('sentinel_menumode', this.menubar.hasClass('slimmenu') ? 'slim' : 'large', {path:'/'});
    },
    
    clearMenuState: function() {
        $.removeCookie('sentinel_activemenuitem', {path:'/'});
        $.removeCookie('sentinel_menumode', {path:'/'});
    },
    
    isIOS: function() {
        return ( navigator.userAgent.match(/(iPad|iPhone|iPod)/g) ? true : false );
    }
         
};

$(function() {
    Sentinel.init();
});

/*!
 * jQuery Cookie Plugin v1.4.1
 * https://github.com/carhartl/jquery-cookie
 *
 * Copyright 2006, 2014 Klaus Hartl
 * Released under the MIT license
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD (Register as an anonymous module)
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// Node/CommonJS
		module.exports = factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var pluses = /\+/g;

	function encode(s) {
		return config.raw ? s : encodeURIComponent(s);
	}

	function decode(s) {
		return config.raw ? s : decodeURIComponent(s);
	}

	function stringifyCookieValue(value) {
		return encode(config.json ? JSON.stringify(value) : String(value));
	}

	function parseCookieValue(s) {
		if (s.indexOf('"') === 0) {
			// This is a quoted cookie as according to RFC2068, unescape...
			s = s.slice(1, -1).replace(/\\"/g, '"').replace(/\\\\/g, '\\');
		}

		try {
			// Replace server-side written pluses with spaces.
			// If we can't decode the cookie, ignore it, it's unusable.
			// If we can't parse the cookie, ignore it, it's unusable.
			s = decodeURIComponent(s.replace(pluses, ' '));
			return config.json ? JSON.parse(s) : s;
		} catch(e) {}
	}

	function read(s, converter) {
		var value = config.raw ? s : parseCookieValue(s);
		return $.isFunction(converter) ? converter(value) : value;
	}

	var config = $.cookie = function (key, value, options) {

		// Write

		if (arguments.length > 1 && !$.isFunction(value)) {
			options = $.extend({}, config.defaults, options);

			if (typeof options.expires === 'number') {
				var days = options.expires, t = options.expires = new Date();
				t.setMilliseconds(t.getMilliseconds() + days * 864e+5);
			}

			return (document.cookie = [
				encode(key), '=', stringifyCookieValue(value),
				options.expires ? '; expires=' + options.expires.toUTCString() : '', // use expires attribute, max-age is not supported by IE
				options.path    ? '; path=' + options.path : '',
				options.domain  ? '; domain=' + options.domain : '',
				options.secure  ? '; secure' : ''
			].join(''));
		}

		// Read

		var result = key ? undefined : {},
			// To prevent the for loop in the first place assign an empty array
			// in case there are no cookies at all. Also prevents odd result when
			// calling $.cookie().
			cookies = document.cookie ? document.cookie.split('; ') : [],
			i = 0,
			l = cookies.length;

		for (; i < l; i++) {
			var parts = cookies[i].split('='),
				name = decode(parts.shift()),
				cookie = parts.join('=');

			if (key === name) {
				// If second argument (value) is a function it's a converter...
				result = read(cookie, value);
				break;
			}

			// Prevent storing a cookie that we couldn't decode.
			if (!key && (cookie = read(cookie)) !== undefined) {
				result[name] = cookie;
			}
		}

		return result;
	};

	config.defaults = {};

	$.removeCookie = function (key, options) {
		// Must not alter options, thus extending a fresh object...
		$.cookie(key, '', $.extend({}, options, { expires: -1 }));
		return !$.cookie(key);
	};

}));