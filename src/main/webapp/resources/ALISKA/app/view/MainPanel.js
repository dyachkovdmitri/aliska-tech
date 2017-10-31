var tabs = [
    {title: 'Запрос цены', xtype: 'getOfferPanel'},
    {title: 'Мои прайс-листы', xtype: 'addPrice'}
];
Ext.define('ALISKA.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.mainpanel',
    //title: 'Алиска',
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
                        Ext.create('Ext.TabPanel', {
                        tabBarPosition: 'bottom',
                        layout: 'fit',
                        width:1900,
                        height:1000,
                        items: tabs
                    })
                ]
            }];
        this.callParent(arguments);
    }
});