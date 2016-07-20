var myHandler = {
	rcvMessage: function(message) {
		alert(message.data);
	}
};
window.onload = function() {
	var amq = org.activemq.Amq;
	amq.init({
		uri: 'amq',
		logging: true,
		timeout: 45,
		clientId: (new Date()).getTime().toString()
	});
	amq.addListener(2, 'topic://zjxxxxx', myHandler.rcvMessage);
	amq.addListener(1, 'topic://zjxx', myHandler.rcvMessage);
};