// // var ajquery = function () {
// //     Ext.onReady(function () {
// //         Ext.Ajax.request({
// //             url: '/loadfile',
// //             success: function (response, options) {
// //                 alert(response.responseText);
// //             },
// //             failure: function (response, options) {
// //                 alert("Ошибка: " + response.statusText);
// //             }
// //         });
// //     });
// // };
var tabs = [
    {title: 'Запросить цены', xtype: 'getOfferPanel'},
    {title: 'Добавить прайс', xtype: 'addPrice'}
];
Ext.define('ALISKA.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.mainpanel',
    title: 'Алиска',
    //views:['addPrice'],
    //store: 'MainStore',

    initComponent: function () {
        var self = this;
        this.items = [
            {
                xtype: 'container',
                layout: {
                    type: 'hbox',
                    align: 'stretch'
                },
                margin: '10 10 10 10',
                combineErrors: true,
                defaultType: 'textareafield',
                items: [
                    // {
                    //     xtype: 'filefield',
                    //     id: 'loadFile',
                    //     margin: '10 10 10 10',
                    //     buttonOnly: true,
                    //     buttonText: 'Загрузить файл .csv',
                    //     hideLabel: true,
                    //     name: 'LoadFile',
                    //     tip: 'Загрузить файл .csv',
                    //     listeners: {
                    //         'change': function (fb) {
                    //             self.fireEvent('fileupload', fb);
                    //         }
                    //     }
                    // },

                    Ext.create('Ext.TabPanel', {
                        //fullscreen: true,
                        tabBarPosition: 'bottom',
                        layout: 'fit',
                        width:1000,
                        height:1000,
                        // defaults: {
                        //     styleHtmlContent: true
                        // },

                        items: tabs
                    })
                ]
            }];
        this.callParent(arguments);
    }
});