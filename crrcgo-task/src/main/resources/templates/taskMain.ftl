<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${crrcgo}</title>
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${request.contextPath}/static/jquery/themes/demo.css">
	<script type="text/javascript" src="${request.contextPath}/static/jquery/js/jquery.min.js"></script>
	<script type="text/javascript" src="${request.contextPath}/static/jquery/js/jquery.easyui.min.js"></script>
</head>
<body>
	<h2>Context Menu on DataGrid</h2>
	<p>Right click on the header of DataGrid to display context menu.</p>
	<div style="margin:20px 0;"></div>
	<table id="dg"></table>
	<script type="text/javascript">
		$(function(){
			$('#dg').datagrid({
				url: 'datagrid_data1.json',
				method: 'get',
				title: '${tableTitle}',
				iconCls: 'icon-save',
				width: 1080,
				height: 250,
				fitColumns: true,
				singleSelect: true,
				columns:[[
					{field:'itemid',title:'${taskTableId}',width:80,align:'center'},
					{field:'productid',title:'${taskTableTitle}',width:120,align:'center'},
					{field:'listprice',title:'${taskTableDescribe}',width:80,align:'center'},
					{field:'status',title:'Status',width:60,align:'center'}
				]],
				onHeaderContextMenu: function(e, field){
					e.preventDefault();
					if (!cmenu){
						createColumnMenu();
					}
					cmenu.menu('show', {
						left:e.pageX,
						top:e.pageY
					});
				}
			});
		});
		var cmenu = null;
		function createColumnMenu(){
			cmenu = $('<div/>').appendTo('body');
			cmenu.menu({
				onClick: function(item){
					if (item.iconCls == 'icon-ok'){
						$('#dg').datagrid('hideColumn', item.name);
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-empty'
						});
					} else {
						$('#dg').datagrid('showColumn', item.name);
						cmenu.menu('setIcon', {
							target: item.target,
							iconCls: 'icon-ok'
						});
					}
				}
			});
			var fields = $('#dg').datagrid('getColumnFields');
			for(var i=0; i<fields.length; i++){
				var field = fields[i];
				var col = $('#dg').datagrid('getColumnOption', field);
				cmenu.menu('appendItem', {
					text: col.title,
					name: field,
					iconCls: 'icon-ok'
				});
			}
		}
	</script>
</body>
</html>
