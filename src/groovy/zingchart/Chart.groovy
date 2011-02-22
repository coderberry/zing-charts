package zingchart

import zingchart.chartGraphSet.*

class Chart implements ChartDefinition {

    String libURL // Path to zingchart.swf
    Integer width
    Integer height
    String containerName // DIV id of target
    ChartGraphSet chartGraphSet
    Float animateSpeed
    Integer effect

    Chart(String chartType) {
        this.chartGraphSet = new ChartGraphSet(chartType)
    }

    Chart(String chartType, String libURL, Integer width, Integer height, String containerName, Float animateSpeed, Integer effect) {
        this.libURL = libURL
        this.width = width
        this.height = height
        this.containerName = containerName
        this.animateSpeed = animateSpeed
        this.chartGraphSet = new ChartGraphSet(chartType)
        this.effect = effect
    }

    void addDataSet(List data, String title) {
        SeriesValues seriesValues = new SeriesValues()
        if (title) {
            seriesValues.title = title
            this.chartGraphSet.scaleY?.labels << title
        }
        if (this.animateSpeed) {
            seriesValues.animate = true
            seriesValues.animateSpeed = this.animateSpeed
            seriesValues.effect = effect ?: 1
            seriesValues.values = data
        }
        this.chartGraphSet.series.seriesValues << seriesValues
    }

    void setHorizontalLabels(List<String> labels) {
        this.chartGraphSet.scaleX.labels = labels
    }

    void setVerticalLabels(ArrayList<String> labels) {
        this.chartGraphSet.scaleY.labels = labels
    }

    String toHTML() {
        """\
<script type="text/javascript">
var ${containerName}JsonConfig = '${this.chartGraphSet.toJSON()}';
\$(function() { zingchart.render({ liburl: '${this.libURL}',
data: ${containerName}JsonConfig, width: ${this.width}, output: 'canvas',
height: ${this.height}, container: '${this.containerName}' }) })
</script>
<div id="${this.containerName}"></div>
"""
    }
}
