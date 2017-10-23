Ext.define('ALISKA.store.ItemPriceStore', {
        extend: 'Ext.data.Store',
        model: "ALISKA.model.ItemPriceModel",
        autoLoad: true,
        storeId: 'ItemPriceStore',
        //data: data,
        proxy: {
            type: 'ajax',
            url: 'customerRequest/getPrice',
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'status'
            }
        }
    }
);