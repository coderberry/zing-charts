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

    <zing:chart 
      type="area" // Type of chart. See http://www.zingchart.com/learn/docs.php for available types (ie. 'area' or 'bar3d')
      width="700" // Display width of the chart
      height="350" // Display height of the chart
      container="acceptToConvertChart" // element ID of the chart container (div)
      data="${stats.data}" // Hash Map of data. Key is the name of the data, value is an array of values. See below for examples
      xLabels="${stats.labels}" // Array of labels
      effect="4" // Animation effect. See http://www.zingchart.com/learn/docs.php for available effects
      />
    