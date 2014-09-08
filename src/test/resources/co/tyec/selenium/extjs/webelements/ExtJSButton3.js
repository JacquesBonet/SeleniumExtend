/*global Ext:false */
Ext.onReady(function () {
    new Ext.Button({
        text: '<code>pressed: false</code>',
        itemId: 'pressed',
        id: 'pressed',
        enableToggle: true,
        handler: function () {
            this.setText('<code>pressed: ' + this.pressed + '</code>');
        },
        renderTo: Ext.getBody()
    });

});
