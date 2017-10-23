// var data =  [{
//     "userID": 1,
//     "name": "Вася",
//     "surname": "Иванов",
//     "date": "10/08/1991",
//     "email": "vasiv@mail.ru",
//     "married": false
// }, {
//     "userID": 2,
//     "name": "Петя",
//     "surname": "Федоров",
//     "date": "03/08/1993",
//     "email": "petfed@yandex.ru",
//     "married": true
// }, {
//     "userID": 3,
//     "name": "Вова",
//     "surname": "Кузнецов",
//     "date": "11/07/1989",
//     "email": "vok@mail.ru",
//     "married": false
// }, {
//     "userID": 4,
//     "name": "Саша",
//     "surname": "Сидоров",
//     "date": "05/08/1991",
//     "email": "vvvs@mail.ru",
//     "married": true
// }]
//
//
// Ext.define('User', {
//     extend: 'Ext.data.Model',
//
//     idProperty: 'userID',
//
//     fields: [{
//         name: 'userID',
//         type: 'int'
//     }, {
//         name: 'name',
//         type: 'string'
//     }, {
//         name: 'surname',
//         type: 'string'
//     }, {
//         name: 'date',
//         type: 'date'
//     }, {
//         name: 'email',
//         type: 'string'
//     }, {
//         name: 'married',
//         type: 'bool'
//     }]
// });
//
// var store = Ext.create('Ext.data.Store', {
//     model:'User' ,
//     data:data,
//     // autoLoad: true,
//     proxy: {
//         type: 'ajax',
//         url: 'offer.json',
//         reader: {
//             type: 'json',
//             root: 'users'
//         }
//     }
// });


Ext.define('ALISKA.view.AddPrice', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.addPrice',
    store: 'ItemOfferStore',
    //store: store,
    initComponent: function () {
        var self = this;
        this.tbar = [{
            xtype: 'filefield',
            id: 'uploadPrice',
            margin: '10 10 10 10',
            buttonOnly: true,
            padding: 10,
            buttonText: 'Загрузить свой прайс',
            hideLabel: true,
            listeners: {
                'change': function (fb) {
                    self.fireEvent('fileupload', fb);
                }
            }
        }];
        this.columns = [{
            header: 'Наименование',
            dataIndex: 'unparsedLine',
            flex: 1
        }, {
            header: 'Количество на складе',
            dataIndex: 'ammount',
            flex: 1
        },
            {
                header: 'Мощность',
                dataIndex: 'wattage',
                flex: 1
            },
            {
                header: 'Мощность',
                dataIndex: 'voltage',
                flex: 1
            }];
        this.callParent(arguments);
    }

});