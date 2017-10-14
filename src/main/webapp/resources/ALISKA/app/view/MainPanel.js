// var ajquery = function () {
//     Ext.onReady(function () {
//         Ext.Ajax.request({
//             url: '/loadfile',
//             success: function (response, options) {
//                 alert(response.responseText);
//             },
//             failure: function (response, options) {
//                 alert("Ошибка: " + response.statusText);
//             }
//         });
//     });
// };
Ext.define('ALISKA.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.mainpanel',
    title: 'Алиска',
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
                margin: '0 0 5 0',
                combineErrors: true,
                defaultType: 'textareafield',
                items: [
                    {
                        xtype: 'filefield',
                        id: 'loadFile',
                        buttonOnly: true,
                        buttonText: 'Загрузить файл .csv',
                        hideLabel: true,
                        name: 'LoadFile',
                        tip: 'Загрузить файл .csv',
                        listeners: {
                            'change': function (fb) {
                                self.fireEvent('fileupload', fb);
                            }
                        }
                    }
                ]
            }];
        this.callParent(arguments);
    }
});