/**
 * 
 * Copyright 2007-2009
 * 
 * Paulius Uza
 * http://www.uza.lt
 * 
 * Dan Florio
 * http://www.polygeek.com
 * 
 * Arif Ali Saiyed
 * http://arif-ali-saiyed.blogspot.com/
 * 
 * Project website:
 * http://code.google.com/p/custom-context-menu/
 * 
 * --
 * RightClick for Flash Player. 
 * Version 0.6.2
 * 
 */

var RightClick = {
		
	registeredSwfs: [],
	registeredContainers: [],
	registerSwf: function (swfId, containerId) {
		RightClick.registeredSwfs[RightClick.registeredSwfs.length] = swfId;
		RightClick.registeredContainers[RightClick.registeredContainers.length] = containerId;
		if(!window.addEventListener){
			document.getElementById(containerId).onmouseup = function() { document.getElementById(containerId).releaseCapture(); }
			document.oncontextmenu = function(){ if(window.event.srcElement.id == swfId) { return false; } else { RightClick.Cache = "nan"; }}
			document.getElementById(containerId).onmousedown = RightClick.onIEMouse;
		}
		RightClick.Cache = swfId;
	},
	/**
	 *  Constructor
	 */ 
	init: function () {		
		if(window.addEventListener){
			 window.addEventListener("mousedown", this.onGeckoMouse(), true);
			 window.addEventListener("mouseup", function(ev){
				 if (ev.button != 0){
				 	RightClick.killEvents(ev);
				 }
				 }, true);
		}
	},

	/**
	 * GECKO / WEBKIT event overkill
	 * @param {Object} eventObject
	 */
	killEvents: function(eventObject) {
		if(eventObject) {
			if (eventObject.stopPropagation) eventObject.stopPropagation();
			if (eventObject.preventDefault) eventObject.preventDefault();
			if (eventObject.preventCapture) eventObject.preventCapture();
	   		if (eventObject.preventBubble) eventObject.preventBubble();
		}
	},
	/**
	 * GECKO / WEBKIT call right click
	 * @param {Object} ev
	 */
	onGeckoMouse: function(ev) {
	  	return function(ev) {
	    if (ev.button != 0) {			
			for (var i=0;i<RightClick.registeredSwfs.length;i++){
				if(ev.target.id == RightClick.registeredSwfs[i] && RightClick.Cache == RightClick.registeredSwfs[i]) {
					RightClick.killEvents(ev);
		    		RightClick.call(RightClick.registeredSwfs[i]);
				}
			}
			RightClick.Cache = ev.target.id;
		}
	  }
	},
	/**
	 * IE call right click
	 * @param {Object} ev
	 */
	onIEMouse: function() {
	  	if (event.button > 1) {
	  		for (var i=0;i<RightClick.registeredSwfs.length;i++){
				if(window.event.srcElement.id == RightClick.registeredSwfs[i] && RightClick.Cache == RightClick.registeredSwfs[i]) {
					RightClick.call(RightClick.registeredSwfs[i]); 
				}
				document.getElementById(RightClick.registeredContainers[i]).setCapture();
	  		}
			if(window.event.srcElement.id)
			RightClick.Cache = window.event.srcElement.id;
		}
	},
	/**
	 * Main call to Flash External Interface
	 */
	call: function(id) {
		document.getElementById(id).rightClick();
	}
}