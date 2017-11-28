Ext.define('ALISKA.model.ItemPriceModel', {
    extend: 'Ext.data.Model',
    idProperty: 'id',

    fields: [{
        name: 'brand',
        type: 'string'
    }, {
        name: 'bulbcolor',
        type: 'int'
    },
        {
            name: 'bulbType',
            type: 'int'
        },
        {
            name: 'companyId',
            type: 'int'
        },
        {
            name: 'type1',
            type: 'int'
        },
        {
            name: 'type2',
            type: 'int'
        },
        {
            name: 'type3',
            type: 'int'
        },
        {
            name: 'type4',
            type: 'int'
        },
        {
            name: 'type5',
            type: 'int'
        },
        {
            name: 'connectorType',
            type: 'int'
        },
        {
            name: 'unparsedLine',
            type: 'string'
        },
        {
            name: 'price',
            type: 'int'
        },
        {
            name: 'wattage',
            type: 'int'
        }, {
            name: 'voltage',
            type: 'int'
        }
    ]
});