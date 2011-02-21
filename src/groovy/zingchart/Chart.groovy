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

    def Chart(String chartType) {
        this.chartGraphSet = new ChartGraphSet(chartType)
    }

    def Chart(String chartType, String libURL, Integer width, Integer height, String containerName, Float animateSpeed, Integer effect) {
        this.libURL = libURL
        this.width = width
        this.height = height
        this.containerName = containerName
        this.animateSpeed = animateSpeed
        this.chartGraphSet = new ChartGraphSet(chartType)
        this.effect = effect
    }

    def void addDataSet(ArrayList data, String title) {
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

    def void setHorizontalLabels(ArrayList<String> labels) {
        this.chartGraphSet.scaleX.labels = labels
    }

    def void setVerticalLabels(ArrayList<String> labels) {
        this.chartGraphSet.scaleY.labels = labels
    }

    def String toHTML() {
        def ret = '<script type="text/javascript">'
        ret += "var ${containerName}JsonConfig = '${this.chartGraphSet.toJSON()}'; "
        ret += "\$(function() { zingchart.render({ liburl: '${this.libURL}', "
        ret += "data: ${containerName}JsonConfig, width: ${this.width}, output: 'canvas', "
        ret += "height: ${this.height}, container: '${this.containerName}' }) })"
        ret += "</script>"
        ret += "<div id=\"${this.containerName}\"></div>"
        return ret
    }

}
