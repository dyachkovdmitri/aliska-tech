Ext.define('ALISKA.view.AddPrice', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.addPrice',
    store: 'ItemPriceStore',
    //store: store,
    initComponent: function () {
        var self = this;
        this.tbar = [
            {
                xtype: 'container',
                style:"border:1px double gray",
                padding:4,
                layout: {
                    type: 'vbox',
                    align: 'stretch'
                },
                items: [
                    {
                        xtype: 'textfield',
                        fieldLabel:'Имя прайса',
                        labelWidth: 40,
                        width: 140
                    },
                    {
                        xtype: 'checkbox',
                        boxLabel: 'виденВсем',
                        id: 'allVisible'
                    }, {
                        xtype: 'filefield',
                        id: 'uploadPrice',
                        //margin: '0 10 10 10',
                        buttonOnly: true,
                        padding: 5,
                        buttonText: 'Загрузить новый прайс',
                        hideLabel: true,
                        listeners: {
                            'change': function (fb) {
                                self.fireEvent('fileupload', fb);
                            }
                        }
                    }]
            }

            ,
            {
                xtype: 'button',
                text: 'Обновить'
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Прайсы',
                padding: 15,
                labelWidth: 45,
                width: 200
            }
        ];
        this.columns = [{
            header: 'Наименование',
            dataIndex: 'unparsedLine',
            flex: 1
        }, {
            header: 'V',
            dataIndex: 'voltage',
            flex: 1
        },
            {
                header: 'W',
                dataIndex: 'wattage',
                flex: 1
            },
            {
                header: 'Цоколь',
                dataIndex: 'connectorType',
                flex: 1
            },
            {
                header: 'Бренд',
                dataIndex: 'brand',
                flex: 1
            },
            {
                header: 'Мощность',
                dataIndex: 'voltage',
                flex: 1
            },
            {
                header: 'ТИП1',
                dataIndex: 'type2',
                flex: 1
            },
            {
                header: 'ТИП2',
                dataIndex: 'type1',
                flex: 1
            },
            {
                header: 'ТИП3',
                dataIndex: 'type3',
                flex: 1
            },
            {
                header: 'ТИП4',
                dataIndex: 'type4',
                flex: 1
            },
            {
                header: 'ТИП5',
                dataIndex: 'type5',
                flex: 1
            }
        ];
        this.callParent(arguments);
    }

});

