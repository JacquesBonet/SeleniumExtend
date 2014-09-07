Ext.onReady(function () {
    var empData = [{
        'emp_no': '1001',
        'last_name': 'Doe',
        'first_name': 'John',
        'age': '23',
        'doj': '08/06/2009',
        'address': '52nd Cross Street'
    }, {
        'emp_no': '1002',
        'last_name': 'Sparrow',
        'first_name': 'Jack',
        'age': '26',
        'doj': '08/12/2010',
        'address': '23rd Street'
    }, {
        'emp_no': '1003',
        'last_name': 'Spacey',
        'first_name': 'Kevin',
        'age': '26',
        'doj': '01/23/2011',
        'address': 'Central Park'
    }, {
        'emp_no': '1004',
        'last_name': 'Gates',
        'first_name': 'Bill',
        'age': '35',
        'doj': '10/10/2006',
        'address': 'Kings Cross'
    }];

    var empStore = new Ext.data.JsonStore({
        fields: [{
            name: 'emp_no'
        }, {
            name: 'last_name'
        }, {
            name: 'first_name'
        }, {
            name: 'age',
            type: 'int'
        }, {
            name: 'doj',
            type: 'date',
            dateFormat: 'm/d/Y'
        }, {
            name: 'address'
        }],
        data: empData
    });

    function showEmpDetails(val, meta, rec, rIndex, cIndex, store) {
        return "<a href='#'>" + val + "</a>";
        //or apply any css class of your choice using
        //meta.css = ‘awesome-font-style’
        //return val;
    }

    var grid = new Ext.grid.EditorGridPanel({
        store: empStore,
        columns: [{
            header: 'Emp No.',
            width: 70,
            sortable: true,
            dataIndex: 'emp_no',
            align: 'center',
            renderer: showEmpDetails
        }, {
            header: 'Last Name',
            width: 100,
            sortable: true,
            dataIndex: 'last_name',
            editor: new Ext.form.TextField({allowBlank: false})
        }, {
            header: 'First Name',
            width: 100,
            sortable: true,
            dataIndex: 'first_name',
            editor: new Ext.form.TextField({allowBlank: false})
        }, {
            header: 'Age',
            width: 75,
            sortable: true,
            dataIndex: 'age',
            editor: new Ext.form.NumberField({
                allowBlank: false,
                allowNegative: false,
                maxValue: 100
            })

        }, {
            header: 'Date of Joining',
            width: 100,
            sortable: true,
            renderer: Ext.util.Format.dateRenderer('m/d/Y'),
            dataIndex: 'doj',
            editor: new Ext.form.DateField({
                format: 'm/d/Y',
                minValue: '01/01/2009'
            })

        }, {
            header: 'Address',
            width: 200,
            dataIndex: 'address',
            editor: new Ext.form.TextField({allowBlank: true})
        }],
        stripeRows: true,
        height: 300,
        width: 440,
        itemId: 'grid',
        id: 'grid',
        renderTo: Ext.getBody()
    });
});