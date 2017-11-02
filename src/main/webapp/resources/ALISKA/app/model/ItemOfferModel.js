Ext.define('ALISKA.model.ItemOfferModel', {
    extend: 'Ext.data.Model',
    //idProperty: 'parsedLine',

    fields: [
        {
            name: 'orderNumber',
            type: 'int'
        },
        {
            name: 'parsedLine',
            type: 'string'
        },
        {
            name: 'ammount',
            type: 'int'
        },
        {
            name: 'unparsedLine',
            type: 'string'
        },
        {
            name: 'assortmentId.unparsedLine',
            type: 'string'
        }
    ]
});