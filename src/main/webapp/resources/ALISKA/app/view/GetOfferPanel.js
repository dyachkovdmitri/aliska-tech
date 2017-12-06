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


Ext.define('ALISKA.view.GetOfferPanel', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.getOfferPanel',
    store: 'ItemOfferStore',

    //store: store,
    initComponent: function () {
        var self = this;
        this.tbar = [{
            xtype: 'filefield',
            id: 'loadFile21',
            margin: '10 10 10 10',
            buttonOnly: true,
            padding: 15,
            buttonText: 'Загрузить заявку',
            hideLabel: true,
            name: 'LoadFile',
            listeners: {
                'change': function (fb) {
                    self.fireEvent('fileupload', fb);
                }
            }
        }, {
            xtype: 'button',
            text: 'Пересчитать заново'
        },
            {
                xtype: 'button',
                text: 'Скачать ТКП'

            },


            {
                xtype: 'checkboxfield',
                boxLabel: 'БрендВажен',
                padding: 15,
                inputValue: '1',
                id: 'checkboxBrand'
            },
            {
                xtype: 'numberfield',
                fieldLabel: 'Точность',
                value: 3,
                maxValue: 7,
                minValue: 0,
                padding: 15,
                id: 'accuracyNumber',
                labelWidth: 60,
                width: 110
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Прайс',
                padding: 15,
                id: 'priceItemId',
                labelWidth: 45,
                width: 200
            }


        ];

        this.plugins = [{
            ptype: 'rowediting',
            clicksToEdit: 1
        }];

        this.columns = [

            {
                header: ' ',
                dataIndex: 'accuracy',
                width: 10,
                renderer: function (value, metaData, record, row, col, store, gridView) {
                    if (value < 3) {
                        metaData.style = 'background:red;';
                    } else if (value == 3) {
                        metaData.style = 'background:yellow;';
                    }
                    else if (value > 3) {
                        metaData.style = 'background:green;';
                    } // background color of pink, font color of red, and font-weight of bold//color:#D10000;font-weight:bold;
                    return value;
                }
            },
            {
                header: 'п/п',
                dataIndex: 'orderNumber',
                width: 30
            },
            {
                header: 'Запрос',
                dataIndex: 'unparsedLine',
                width: 450,
                editor: {
                    xtype: 'textfield',
                    allowBlank: false
                }
            },
            {
                header: 'Аналог',
                dataIndex: 'assortmentId.unparsedLine',
                width: 450
            },
            {
                header: 'Количество',
                dataIndex: 'ammount',
                width: 70,
                renderer: function (value){return value+" шт."}
            },
            {
                header: 'Цена',
                dataIndex: 'assortmentId.price',
                width: 70,
                renderer: function (value){return value+" р."}
            },
            {
                header: 'Сумма',
                dataIndex: 'sum',
                width: 70,
                renderer: function (value){return value+" р."}
            },
            {
                header: 'Комментарии',
                dataIndex: 'parsedLine',
                flex: 1
            }
        ];
        this.callParent(arguments);
    }


});
