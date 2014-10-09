/**
 * auter Asaf levy
 *Extend javastring String function
 *
 */


function installAjaxListeners() {
	window.wasAjaxFailure = false;
	window.ajaxCalls = [];
	Ext.Ajax.on('requestexception', function() {(window.wasAjaxFailure = true)}, this);
	Ext.Ajax.on('beforerequest', function(conn, options) {
		window.ajaxCalls.push(conn.transId);
	});
}

Ext.onReady(function(){
	installAjaxListeners();
});


String.prototype.trim = function() {
	return this.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
};

String.prototype.ltrim = function() {
	if (this)
		return this.replace(/^\s+/, '');
};

String.prototype.rtrim = function() {
	return this.replace(/\s+$/, '');
};

String.prototype.fulltrim = function() {
	return this.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g, '')
			.replace(/\s+/g, ' ');
};

/**
 * start trim on string from the left string side
 * @param {String} s
 * @return {Boolean}
 */

function ltrim(s) {
	if (!s)
		return false;
	var l = 0;
	while (l < s.length && s[l] == ' ') {
		l++;
	}
	return s.substring(l, s.length);
}

/**
 * start trim on string from the right string side
 * @param {String} s
 * @return {Boolean}
 */
function rtrim(s) {
	if (!s)
		return false;
	var r = s.length - 1;
	while (r > 0 && s[r] == ' ') {
		r -= 1;
	}
	return s.substring(0, r + 1);
}

/**
 * removing the last charecter from given string
 * @param {String} s
 */
function rlastchar(s) {
	if (!s)
		return false;
	return s.substring(0, s.length - 1);
}

function foundIn(component, xtype) {
	var xtypes = component.getXTypes().split("/");
	var i = 0;
	for (i; i < xtypes.length; i++) {
		if (xtype == xtypes[i])
			return true
    }
	return false
}

/**
 * main function return  extjs component id from the Exjs component manager
 * @param {String} text - text to search (title,lable,text....)
 * @param {String} xtype - component type like grid,textfield,combobox ....)
 * @return {}
 */
var findComponentByText = function(text, xtype, incInvisible, debug) {
	var timeStart;
	if(debug){
		timeStart = (new Date()).getTime();
	}
	var item = "";
	var items = "";
	Ext.ComponentMgr.all.find(function(c) {
            if (xtype) {
                if (text) {
                    if ((incInvisible || c.isVisible())
                            && (rtrim(ltrim(c.text)) == text
                            || rtrim(ltrim(c.boxLabel)) == text
                            || rtrim(ltrim(c.fieldLabel)) == text || rtrim(ltrim(c.title)) == text)
                            && (c.getXType() == rtrim(ltrim(xtype))
                                    || c.xtype == rtrim(ltrim(xtype)) || c.type == rtrim(ltrim(xtype))))
                        item += c.id+  ",";
                } else {
                    if ((incInvisible || c.isVisible())
                            && (c.getXType() == rtrim(ltrim(xtype))
                                    || c.xtype == rtrim(ltrim(xtype)) || c.type == rtrim(ltrim(xtype))))
                        items += c.id + ",";
                }
            } else {
                if ((incInvisible || c.isVisible())
                        && ((rtrim(ltrim(c.text)) == text
                                || rtrim(ltrim(c.fieldLabel)) == text || rtrim(ltrim(c.title)) == text)))
                    item += c.id + ",";
            }
	});
	if(debug){
		var dur = (new Date()).getTime() - timeStart;
		ttp.logDebug("findComponent took: "+dur+"ms");
	}
	if (item) {
		return rlastchar(item);
	} else {
		if (items) {
			return rlastchar(items);
		}
		return null;
	}
};

function getElementIdx(elt)
{
    var count = 1;
    for (var sib = elt.previousSibling; sib ; sib = sib.previousSibling)
    {
        if(sib.nodeType == 1 && sib.tagName == elt.tagName)	count++
    }
    
    return count;
}

function createXPathFromElement(element)
	{
		var path = "";
		for (; element && element.nodeType == 1; element = element.parentNode)
			{
				idx = getElementIdx(element);
				xname = element.tagName;
				xname += "[" + idx + "]";
				path = "/" + xname + path;
			}
		
		return "/" + path;
	}


function lookupElementByXPath(path) {
	var evaluator = new XPathEvaluator();
	var result = evaluator.evaluate(path, document.documentElement, null,
			XPathResult.FIRST_ORDERED_NODE_TYPE, null);
	return result.singleNodeValue;
}

/**
 * try to search in components like windows panels etc.. for some prop
 * @param conponentId
 * @param text
 * @param xtype
 */
function findInComponentByText(conponentId, text, xtype) {
	var item = null;

    var component = Ext.getCmp(conponentId);
	var componentsArray = component.findBy(function(c) {
				return true
			});
	Ext.each(componentsArray, function(c, index) {
		if ((c.isVisible())
				&& (rtrim(ltrim(c.text)) == text
						|| rtrim(ltrim(c.fieldLabel)) == text || rtrim(ltrim(c.title)) == text)
				&& (c.getXType() == rtrim(ltrim(xtype))
						|| c.xtype == rtrim(ltrim(xtype)) || c.type == rtrim(ltrim(xtype)))) {
			item = c;
		}
	});

	if (item != null) {
		return c.getId();
	} else {

		switch (xtype) {
			case 'button' :
				if (component.getXType() == 'window') {
					var winButtons = component.buttons;
					Ext.each(winButtons, function(c, index) {
						if ((c.isVisible())
								&& (rtrim(ltrim(c.text)) == text
										|| rtrim(ltrim(c.fieldLabel)) == text || rtrim(ltrim(c.title)) == text)
								&& (c.getXType() == rtrim(ltrim(xtype))
										|| c.xtype == rtrim(ltrim(xtype)) || c.type == rtrim(ltrim(xtype)))) {
							item = c;
						}
					});
					break;
				}
		}
	}
	if (item != null) {
		return item.getId();
	} else {
		return null;
	}
}

 

function verifyNoAjaxCalls() {
	for (i in window.ajaxCalls) {
		var ajaxLoading = Ext.Ajax.isLoading(window.ajaxCalls[i]);
		if (ajaxLoading) {
			return false;
		}
	}
	return true;
}
var ttp = {};
ttp.logDebug = function(message){
	if(console){
		console.log(message)
	}
};
