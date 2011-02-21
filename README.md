Zing Chart Plugin
=================

This plugin allows you to easily integrate Zing Charts (http://www.zingchart.com) into your Grails projects.

To use the plugin, you must have the javascript include in your HTML header:

    ...
    <head>
      <zing:include />
    </head>
    ...
    
In the body where you want the chart to appear, use the taglib provided:

    <zing:chart type="area" width="700" height="350" container="acceptToConvertChart" data="${data}" xLabels="${labels}" effect="4" />
    
*type* - Type of chart. See http://www.zingchart.com/learn/docs.php for available types (ie. 'area' or 'bar3d')

*width* - Display width of the chart

*height* - Display height of the chart

*container* - element ID of the chart container (div)

*data* - Hash Map of data. Key is the name of the data, value is an array of values. See below for examples

*xLabels* - Array of labels

*effect* - Animation effect. See http://www.zingchart.com/learn/docs.php for available effects

** Example Data

    def labels = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    def data = [
      'Visitors': [100, 300, 200, 240, 500, 100, 80],
      'Purchases': [30, 50, 12, 20, 55, 20, 10]
    ]
    