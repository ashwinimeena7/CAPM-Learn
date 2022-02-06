sap.ui.define(['sap/ui/core/mvc/Controller',
				'jquery.sap.global',
				'ashwini/util/service',
				'sap/m/MessageBox'
			],
function(Controller, jQuery, service, MessageBox){
	return Controller.extend("ashwini.controller.Main",{
	
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"postPayload": {
					    "companyName": "SAP",
					    "firstName": "ABC",
					    "lastName": "Meena",
					    "website": "contact@abc.meena",
					    "email": "abc.meena@sap.com",
					    "status": "A",
					    "gstNo": "GST987"
					},
				"vendor": {}
			});
			sap.ui.getCore().setModel(oModel);
		},
	
		onPress: function(){
			var that = this;
			service.callService("/vendor", "GET", {})
			.then(function(data){
				var oTable = that.getView().byId("idTable");
				var oModel = sap.ui.getCore().getModel();
				oModel.setProperty("/vendor",data);
				//oModel.setProperty("/vendor",data._embedded.vendor);
				oTable.bindRows("/vendor");
			}).catch(function(err){
			
			});
		},
		
		onDelete: function(){
			var that = this;
			var aIndices = that.getView().byId("idTable").getSelectedIndex();
			var vId = sap.ui.getCore().getModel().getData().vendor[aIndices].id;
			var sUrl = "/vendor/" + vId;
			service.callService(sUrl, "DELETE", {})
			.then(function(data){
				MessageBox.confirm(data);
				sap.ui.getCore().getModel().refresh(true);
				sap.ui.getCore().getModel().updateBindings(true);
			}).catch(function(err){
				MessageBox.confirm("Delete failed");
			});
		},
		
		onSave: function(){
			var oModel = sap.ui.getCore().getModel();
			var payload = oModel.getProperty("/postPayload");
			var that = this;
			service.callService("/vendor", "POST", payload)
			.then(function(data){
				MessageBox.confirm("Saved success");
			}).catch(function(err){
				MessageBox.confirm("Post failed");
			});
		}
		
	});
});