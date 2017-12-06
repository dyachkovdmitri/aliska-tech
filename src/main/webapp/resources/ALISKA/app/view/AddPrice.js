Ext.define('ALISKA.view.AddPrice', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.addPrice',
    height:700,
    store: 'ItemPriceStore',
    initComponent: function () {

        this.columns = [{
            header: 'Наименование',
            dataIndex: 'unparsedLine',
            flex: 1
        },
            {
                header: 'Цена',
                dataIndex: 'price',
                flex: 1
            },
            {
                header: 'Количество',
                dataIndex: 'ammount',
                flex: 1
            },

            {
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
        console.log(Ext.getStore('PriceStore'));
        this.callParent(arguments);
    }

});

