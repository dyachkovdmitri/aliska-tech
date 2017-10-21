Ext.define('ALISKA.view.AddPrice', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.addPrice',
    title: 'Алиска',
    html:"Добавить прайс",
    bbar:[{
        xtype: 'filefield',
        id: 'loadFile',
        margin: '10 10 10 10',
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
    }]

    //views:['addPrice'],
    //store: 'MainStore',

    // initComponent: function () {
    //     //tbar: buttons,
    //     console.log("Привет23!");
    //     // this.items = [
    //     //     {
    //     //         xtype: 'container',
    //     //         layout: {
    //     //             type: 'hbox',
    //     //             align: 'stretch'
    //     //         },
    //     //         margin: '10 10 10 10',
    //     //         combineErrors: true,
    //     //         items: [
    //     //             {
    //     //                 xtype: 'tabpanel',
    //     //                 itemId: 'mainTabPanel',
    //     //                 layout: 'fit',
    //     //                 items: tabs
    //     //             }]
    //     //
    //     //
    //     //
    //     //     }];
    //     // this.callParent(arguments);
    // }
});