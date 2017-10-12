Ext.define('ALISKA.view.MainList' ,{
    extend: 'Ext.grid.Panel',
    alias: 'widget.mainlist',

    title: 'Заявки',
    store: 'MainStore',

    initComponent: function() {
        this.columns = [
            {header: 'Товар',  dataIndex: 'name',  flex: 1},
            {header: 'Цена',  dataIndex: 'price',  flex: 1},
            {header: 'Количество', dataIndex: 'count', flex: 1}
        ];
        this.callParent(arguments);
    }
});