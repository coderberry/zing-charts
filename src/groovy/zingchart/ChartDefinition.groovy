package zingchart

public interface ChartDefinition {

    static CHART_TYPES = [
            "area3d", "bar3d", "hbar3d", "hfunnel3d", "line3d", "pie3d", "vfunnel3d",
            "area", "bar", "bubble", "gauge", "hbar", "hbullet", "hfunnel",
            "line", "nestedpie", "piano", "pie", "radar", "scatter", "stock", "venn",
            "vbullet", "vfunnel"
    ]

    static CHART_LAYOUTS = [
            "1x2"
    ]

    static CHART_ANIMATIONS = [
            stretchVertical: 1,
            stretchHorizontal: 2,
            slideDown: 3,
            slideUp: 4,
            slideRight: 5,
            slideLeft: 6
    ]

}