Ext.define('User', {
    extend: 'Ext.data.Model',

    idProperty: 'userID',

    fields: [{
        name: 'userID',
        type: 'int'
    }, {
        name: 'name',
        type: 'string'
    }, {
        name: 'surname',
        type: 'string'
    }, {
        name: 'date',
        type: 'date'
    }, {
        name: 'email',
        type: 'string'
    }, {
        name: 'married',
        type: 'bool'
    }]
});

var store = Ext.create('Ext.data.Store', {
    model: 'User',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: 'users.json',
        reader: {
            type: 'json',
            root: 'users'
        }
    }
});

Ext.create('Ext.grid.Panel', {
    title: 'Пользователи',
    alias: 'widget.exampleGridPanel',
    height: 200,
    width: 400,
    store: store,
    columns: [{
        header: 'Имя',
        dataIndex: 'name'
    }, {
        header: 'Фамилия',
        dataIndex: 'surname'
    }, {
        header: 'Дата рождения',
        dataIndex: 'date',
        xtype:'datecolumn',
        format: 'd/m/Y',
        flex:1
    }, {
        header: 'E-mail',
        dataIndex: 'email',
        flex:1
    }, {
        header: 'Женат/Замужем',
        dataIndex: 'married',
        flex:1
    }],
    renderTo: Ext.getBody()
});

