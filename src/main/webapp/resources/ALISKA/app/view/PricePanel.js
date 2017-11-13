Ext.define('ALISKA.view.PricePanel', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.pricePanel',
    initComponent: function () {
        var self = this;

        var states = Ext.create('Ext.data.Store', {
            fields: ['id', 'priceName'],
            storeId: 'PriceStore',
            autoload: true,
            proxy: {
                type: 'ajax',
                url: 'price/getAvailable',
                reader: {
                    type: 'json',
                    root: 'data',
                    successProperty: 'status'
                }
            }
        });

        this.items = [
            {
                xtype: 'container',
                layout: {
                    type: 'hbox'
                    //align: 'stretch'
                },
                items: [
                    {
                        xtype: 'container',
                        padding: 5,
                        layout: {
                            type: 'hbox',
                            align: 'stretch'
                        },
                        items: [

                            {
                                xtype: 'container',
                                style: "border:1px double gray",
                                padding: 4,
                                layout: {
                                    type: 'hbox',
                                    align: 'stretch'
                                },
                                items: [
                                    {
                                        xtype: 'textfield',
                                        padding: 4,
                                        fieldLabel: 'Имя прайса',
                                        labelWidth: 40,
                                        width: 140
                                    },
                                    {
                                        xtype: 'checkbox',
                                        padding: 4,
                                        boxLabel: 'виденВсем',
                                        id: 'allVisible'
                                    }, {
                                        xtype: 'filefield',
                                        id: 'uploadPrice',
                                        padding: 4,
                                        //margin: '0 10 10 10',
                                        buttonOnly: true,
                                        buttonText: 'Загрузить новый прайс',
                                        hideLabel: true,
                                        listeners: {
                                            'change': function (fb) {
                                                console.log("afd");
                                                self.fireEvent('fileupload', fb);
                                            }
                                        }
                                    }]
                            }]
                    },
                    {
                        xtype: 'button',
                        margin: 15,
                        text: 'Обновить'
                    },
                    Ext.create('Ext.form.ComboBox', {
                        fieldLabel: 'Прайсы',
                        store: states,
                        padding: 15,
                        displayField: 'priceName',
                        valueField: 'id',
                        listeners:{
                        'select': function(value, record){
                            document.cookie = "priceId=" + record;
                            Ext.getStore('ItemOfferStore').load();
                            console.log(record);}
                    }
                    })


                ]
            },
            {xtype: 'addPrice'}];
        this.callParent(arguments);


    }

});