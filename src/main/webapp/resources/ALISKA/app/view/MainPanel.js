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
                    type: 'vbox',
                    align: 'stretch'
                },
                margin: '10 10 10 10',
                combineErrors: true,
                defaultType: 'textareafield',
                items: [
                    {
                        xtype: 'container',
                        bodyPadding: 10,
                        layout: {
                            type: 'hbox',
                            align: 'stretch'
                        },
                        items: [
                            {
                                xtype: 'image',
                                src: 'https://www.extremetech.com/wp-content/uploads/2015/09/sat-ai-head-640x353.jpg',
                                mode : 'image',
                                region: 'west',
                                padding:10,
                                width: 100,
                                height: 100,
                                style:"border-radius: 30px"
                            }
                            , {
                                xtype: 'textareafield',
                                padding:10,
                                style:"border-radius: 5px",
                                preventScrollbars:true,
                                value:' - Привет!  Я - Алиска.  Я - обучающаяся нейронная сеть. Я делаю счета на лампы.\r\n  ' +
                                'Ты можешь больше узнать обо мне в разделе FAQ.\r\n \r\n  А пока просто нажми "ЗАГРУЗИТЬ ЗАЯВКУ" и посмотри что получится!',
                                width: 900
                            }]
                    },
                    Ext.create('Ext.TabPanel', {
                        tabBarPosition: 'bottom',
                        layout: 'fit',
                        width: 1900,
                        height: 1000,
                        items: tabs
                    })
                ]
            }];
        this.callParent(arguments);
    }
});