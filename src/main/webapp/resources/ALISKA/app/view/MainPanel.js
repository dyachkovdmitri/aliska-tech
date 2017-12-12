var tabs = [
    {title: 'Запрос цены', xtype: 'getOfferPanel'},
    {title: 'Мои прайс-листы', xtype: 'pricePanel'}
];
Ext.define('ALISKA.view.MainPanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.mainpanel',
    //enableKeyEvents:true,
    //title: 'Алиска',
    initComponent: function () {
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
                    {
                        xtype: 'container',
                        width: 600,
                        bodyPadding: 10,
                        layout: {
                            type: 'vbox',
                            align: 'stretch'
                        },
                        items: [
                            // {
                            //     xtype: 'image',
                            //     src: 'https://www.extremetech.com/wp-content/uploads/2015/09/sat-ai-head-640x353.jpg',
                            //     mode: 'image',
                            //     region: 'west',
                            //     padding: 10,
                            //     width: 50,
                            //     height: 100,
                            //     style: "border-radius: 30px"
                            // }
                            {
                                xtype: 'panel',
                                width: 630,
                                padding: 10,
                                autoScroll: true,
                                height: 800,
                                items: [
                                    {
                                        xtype: 'displayfield',
                                        padding: 10,
                                        border: true,
                                        width: 500,
                                        id: "aliskaMonolog",
                                        //style: "border-radius: 5px",
                                        // preventScrollbars: true,
                                        value: ' - Привет!  Я - Алиска.  Я - обучающаяся нейронная сеть. Я делаю счета на лампы.\r\n  ' +
                                        'Ты можешь больше узнать обо мне в разделе FAQ.\r\n \r\n  А пока просто нажми "ЗАГРУЗИТЬ ЗАЯВКУ" и посмотри что получится!',
                                    },]
                            },

                            {
                                xtype: 'container',
                                width: 500,
                                bodyPadding: 2,
                                layout: {
                                    type: 'hbox',
                                    align: 'stretch'
                                },
                                items: [
                                    {
                                        xtype: 'textareafield',
                                        region: 'east',
                                        padding: 10,
                                        width: 90,
                                        height: 90,
                                        value: 'Привет!',
                                        style: "border-radius: 30px",
                                        fieldStyle: {
                                            'fontFamily': 'arial',
                                            'fontSize': '20px',
                                            'border-radius': '30px',
                                            'text-align': 'center',
                                            'vertical-align': 'middle'
                                        },
                                        listeners: {
                                            afterrender: function (first, second) {
                                                if (!document.cookie.includes("customerAliskaId")) {
                                                    Ext.Ajax.request({
                                                        url: '/customer/getCookie',
                                                        async: false,
                                                        success: function (response, options) {
                                                            document.cookie = "customerAliskaId=" + JSON.parse(response.responseText).msg;
                                                        }
                                                    })
                                                }
                                                Ext.Ajax.request({
                                                    url: '/customer/getMe',
                                                    success: function (response, options) {
                                                        var data = JSON.parse(response.responseText);
                                                        var name = data.msg.split(",")[0];
                                                        first.setValue(name);
                                                        //Ext.getCmp('moiMonolog').setValue("Алиска, спасибо большое! Я загрузил " + nameNumber.split(",")[1] + " прайс уже!!!");
                                                        Ext.speak();
                                                    },
                                                    failure: function (response, options) {
                                                        console.log(response);
                                                    }
                                                });
                                                console.log(document.cookie);
                                            }

                                        }
                                    },
                                    {
                                        xtype: 'textareafield',
                                        padding: 2,
                                        id: "moiMonolog",
                                        fieldStyle: {
                                            'border-radius': '5px'
                                        },
                                        preventScrollbars: true,
                                        value: '',
                                        enableKeyEvents: true,
                                        flex: 1,
                                        listeners: {
                                            'keypress': function (field, event) {
                                                if (event.getKey() == event.ENTER && field.value.length > 3) {

                                                    var valueField = field.value;
                                                    field.setValue("...");
                                                    Ext.Ajax.request({
                                                        url: '/monolog/checkWord',
                                                        params: {
                                                            word: valueField
                                                        },
                                                        success: function (response, options) {
                                                            if (response.responseText.includes("customerAliskaId")) {
                                                                document.cookie = JSON.parse(response.responseText).msg
                                                            }
                                                            field.setValue("");
                                                            Ext.speak();
                                                        },
                                                        failure: function (response, options) {
                                                            console.log(response);
                                                        }
                                                    })
                                                }
                                                // 'change': function (first, value) {
                                                //     if (value.length > 3)
                                                //         Ext.Ajax.request({
                                                //             url: '/monolog/checkWord',
                                                //             params: {
                                                //                 word: value
                                                //             },
                                                //             success: function (response, options) {
                                                //                 Ext.speak();
                                                //                 var aliskaMonolog = JSON.parse(response.responseText).aliskaMonolog;
                                                //                 Ext.getCmp('aliskaMonolog').setValue(aliskaMonolog);
                                                //             },
                                                //             failure: function (response, options) {
                                                //                 console.log(response);
                                                //             }
                                                //         })
                                                // }
                                            }


                                        }
                                    }]
                            },
                            // {
                            //     xtype: 'button',
                            //     text: 'выйти',
                            //     width: 30,
                            //     handler:
                            //         function () {
                            //             var date = new Date(0);
                            //             document.cookie = "customerAliskaId=; expires=" + date.toUTCString();
                            //             Ext.speak();
                            //         }
                            // }
                        ]
                    },
                    Ext.create('Ext.TabPanel', {
                        tabBarPosition: 'bottom',
                        layout: 'fit',
                        flex: 1,
                        height: 900,
                        items: tabs
                    })
                ]
            }];
        this.callParent(arguments);
    }
});