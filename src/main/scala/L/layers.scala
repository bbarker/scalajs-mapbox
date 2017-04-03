package io.github.bbarker.L

import scala.scalajs.js
import scala.scalajs.js.|
import scala.scalajs.js.annotation.JSName

import org.scalajs.dom.html.Element

import io.github.bbarker.L.mapbox._

/**
 * Created by Brandon Elam Barker on 7/22/2015.
 */


/*      Core Classes      */

@js.native
@JSGlobal("L.Class")
class Class() extends js.Object {

}

@js.native
@JSGlobal("L.Evented")
class Evented() extends Class {
  def on(
          types: js.Object,
          fn: js.Function = null,
          context: js.Object = null
          ): Evented = js.native

}

/*      Layer Classes     */

@js.native
@JSGlobal("L.Layer")
class Layer(options: js.Object = null) extends Evented {

  def addTo(map: mapbox.Map): Layer = js.native

  def hasLayer(layer: Layer): Boolean = js.native

  def removeLayer(layer: Layer): Map = js.native

}

@js.native
@JSGlobal("L.LayerGroup")
class LayerGroup(options: js.Object = null) extends Layer {

  def addLayer(layer: Layer): LayerGroup = js.native

  def setZIndex(zIndex: Int): LayerGroup = js.native

}

@js.native
@JSGlobal("L.Marker")
class Marker(latlng: js.Array[Double], options: js.Object = null
            ) extends Layer {

  def setZIndexOffset(offset: Int): Marker = js.native

}

@js.native
@JSGlobal("L.FeatureGroup")
class FeatureGroup(options: js.Object = null) extends LayerGroup {

  def setStyle(style: js.Object): FeatureGroup = js.native

}

@js.native
@JSGlobal("L.GeoJSON")
class GeoJSON(geoJsonFeature: js.Object = null, options: js.Object = null
             ) extends FeatureGroup {

  def addData(geojson: GeoJSON): GeoJSON = js.native

  def resetStyle(layer: Layer): GeoJSON = js.native

  override
  def setStyle(style: js.Object): GeoJSON = js.native

}

@js.native
@JSGlobal("L.GridLayer")
class GridLayer(options: js.Object = null) extends Layer {

  def setZIndex(zIndex: Int): Layer = js.native

}

@js.native
@JSGlobal("L.TileLayer")
class TileLayer(options: js.Object = null) extends GridLayer {

}

@js.native
@JSGlobal("L.Popup")
class Popup(options: js.Object = null) extends Layer {

  def openOn(map: mapbox.Map): Popup = js.native

  def setContent(content: String): Popup = js.native

  def setLatLng(latlng: js.Array[Double]): Popup = js.native

  var _map: mapbox.Map = js.native

}

@js.native
@JSGlobal("L.Path")
class Path(options: js.Object = null) extends Layer {

}

@js.native
@JSGlobal("L.CircleMarker")
class CircleMarker(latlng: js.Object,
                   options: js.Object = null
                  ) extends Path {

}


/*      Other  classes       */
@js.native
@JSGlobal("L.LatLngBounds")
class LatLngBounds() extends js.Object

@js.native
@JSGlobal("L.Control")
class Control extends Class {

  def addTo(map: mapbox.Map): Control = js.native


  //FIXME: what is a container, really?
  type Container = js.Object
  var onAdd: js.Function1[mapbox.Map, Container] = js.native
}

@js.native
@JSGlobal("L.Control.Attribution")
class ControlAttribution extends Control {
  def addAttribution(text: String): ControlAttribution = js.native
}

@js.native
@JSGlobal("L.DomUtil")
object DomUtil extends js.Object {
  def create(
              tagName: String,
              className: String,
              container: js.Object = null
              ): Element = js.native
}


@js.native
@JSGlobal("L.Icon")
class Icon extends Class {

}


@js.native
@JSGlobal("L.DivIcon")
class DivIcon(geoJsonFeature: js.Object = null, options: js.Object = null
             ) extends Icon {

}

object Helpers {

  /**
   * String is a URL or mapbox map identifier. Object specifies
   * a more complexly defined map.
   */
  type MapDescriptor = String | js.Object

  implicit class PopupExtension(val self: Popup) extends AnyVal {
    def hasMap: Boolean = js.DynamicImplicits.truthValue(
      self._map.asInstanceOf[js.Dynamic]
    )

  }
}



/*     End Layer Classes    */

@js.native
@JSGlobal("L")
object L extends js.Object {

  def circleMarker(latlng: js.Object,
                   options: js.Object = null
                  ): GeoJSON = js.native

  def divIcon(options: js.Object = null): DivIcon = js.native

  def control(options: js.Object): Control = js.native

  def geoJson(geoJsonFeature: js.Object, options: js.Object = null): GeoJSON = js.native

  def tileLayer(urlTemplate: String, options: js.Object = null): TileLayer = js.native
}
