var data = [{
    "parsedLine": "Вася",
    "unparsedLine": "Иванов",
    "ammount": 23

}];
//
// Ext.define('Item', {
//     extend: 'Ext.data.Model',
//
//     idProperty: 'userID',
//
//     fields: [{
//         name: 'parsedLine',
//         type: 'string'
//     }, {
//         name: 'unparsedLine',
//         type: 'string'
//     },
//         {
//             name: 'ammount',
//             type: 'int'
//         }]
// });

Ext.define('ALISKA.store.ItemOfferStore', {
        extend: 'Ext.data.Store',
         model: "ALISKA.model.ItemOfferModel",
       // model: 'Item',
        autoLoad: true,
        storeId: 'ItemOfferStore',
        data: data,
        proxy: {
            type: 'ajax',
            url: 'app/data/books.json',
            reader: {
                type: 'json',
                root: 'books',
                successProperty: 'success'
            }
        }
    }
);