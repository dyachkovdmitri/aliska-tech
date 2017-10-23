Ext.define('ALISKA.model.ItemPriceModel', {
    extend: 'Ext.data.Model',
    idProperty: 'id',

    fields: [{
        name: 'parsedLine',
        type: 'string'
    }, {
        name: 'ammount',
        type: 'int'
    }]
});