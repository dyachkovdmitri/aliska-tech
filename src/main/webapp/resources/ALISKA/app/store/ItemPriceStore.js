Ext.define('ALISKA.store.ItemPriceStore', {
        extend: 'Ext.data.Store',
        model: "ALISKA.model.ItemPriceModel",
        autoLoad: true,
        storeId: 'ItemPriceStore',
        //data: data,
        proxy: {
            type: 'ajax',
            url: 'item/getPrice',
            reader: {
                type: 'json',
                root: 'data',
                successProperty: 'status'
            }
        }
    }
);