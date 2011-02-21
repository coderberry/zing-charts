function cloneFont(oFont) {
	var oNewFont = {};
	for (c in oFont) {
		oNewFont[c] = {
			w : oFont[c]['w'],
			n : oFont[c]['n'],
			d : []
		};
		for (var i=0;i<oFont[c]['d'].length;i++) {
			var a = oFont[c]['d'][i];
			if (typeof(a) == 'string') {
				oNewFont[c]['d'].push(oFont[c]['d'][i]);
			} else {
				oNewFont[c]['d'].push([oFont[c]['d'][i][0],oFont[c]['d'][i][1]]);
			}
		}
	}
	return oNewFont;
};
strokeFont['sans-serif-u'] = cloneFont(strokeFont['sans-serif']);
for (var c in strokeFont['sans-serif']) {
	strokeFont['sans-serif-u'][c]['n'] += 2;
	strokeFont['sans-serif-u'][c]['d'].push('m');
	strokeFont['sans-serif-u'][c]['d'].push([0,-6]);
	strokeFont['sans-serif-u'][c]['d'].push('l');
	strokeFont['sans-serif-u'][c]['d'].push([strokeFont['sans-serif-u'][c]['w'],-6]);
}
strokeFont['sans-serif-i'] = cloneFont(strokeFont['sans-serif']);
strokeFont['sans-serif-u-i'] = cloneFont(strokeFont['sans-serif-u'])
for (var c in strokeFont['sans-serif']) {
	for (var i=0;i<strokeFont['sans-serif'][c]['d'].length;i++) {
		var a = strokeFont['sans-serif'][c]['d'][i];
		if (typeof(a) != 'string') {
			if (strokeFont['sans-serif'][c]['d'][i][1] < 4) {
				strokeFont['sans-serif-i'][c]['d'][i][0] -= 3;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] -= 3;
			} if (strokeFont['sans-serif'][c]['d'][i][1] >= 4 && strokeFont['sans-serif'][c]['d'][i][1] < 8) {
				strokeFont['sans-serif-i'][c]['d'][i][0] -= 2;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] -= 2;
			} else if (strokeFont['sans-serif'][c]['d'][i][1] >= 8 && strokeFont['sans-serif'][c]['d'][i][1] < 12) {
				strokeFont['sans-serif-i'][c]['d'][i][0] -= 1;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] -= 1;
			} else if (strokeFont['sans-serif'][c]['d'][i][1] > 12 && strokeFont['sans-serif'][c]['d'][i][1] <= 16) {
				strokeFont['sans-serif-i'][c]['d'][i][0] += 1;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] += 1;
			} else if (strokeFont['sans-serif'][c]['d'][i][1] > 16 && strokeFont['sans-serif'][c]['d'][i][1] <= 20) {
				strokeFont['sans-serif-i'][c]['d'][i][0] += 2;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] += 2;
			} else if (strokeFont['sans-serif'][c]['d'][i][1] > 20) {
				strokeFont['sans-serif-i'][c]['d'][i][0] += 3;
				strokeFont['sans-serif-u-i'][c]['d'][i][0] += 3;
			}
		}
	}
}