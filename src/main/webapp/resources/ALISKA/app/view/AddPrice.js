Ext.define('ALISKA.view.AddPrice', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.addPrice',
    store: 'ItemPriceStore',
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
        },
            {
                xtype: 'button',
                text: 'Обновить'
            },
            {
                xtype: 'combobox',
                fieldLabel: 'Прайс',
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

