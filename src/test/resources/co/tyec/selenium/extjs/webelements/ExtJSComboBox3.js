/*global Ext:false */
Ext.onReady(function () {
    // The data store containing the list of states
    var states = new Ext.data.ArrayStore({
        fields: ['abbr', 'name'],
        data: [[
            "AL",
            "Alabama"
        ], [
            "AK",
            "Alaska"
        ], [
            "AZ",
            "Arizona"
        ]
            //...
        ]
    });


    // Create the combo box, attached to the states data store
    new Ext.form.ComboBox({
        fieldLabel: 'Choose State',
        typeAhead: true,
        triggerAction: 'all',
        lazyRender: true,
        mode: 'local',
        store: states,
        name: 'state',
        displayField: 'name',
        valueField: 'name',
        renderTo: Ext.getBody()
    });
});
