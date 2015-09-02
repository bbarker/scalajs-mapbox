package io.github.bbarker.L

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

import org.scalajs.dom.html.Element

import io.github.bbarker.L.mapbox._

/**
 * Created by Brandon Elam Barker on 7/22/2015.
 */


/*      Core Classes      */

@JSName("L.Class")
class Class() extends js.Object {

}

@JSName("L.Evented")
class Evented() extends Class {
  def on(
          types: js.Object,
          fn: js.Function = null,
          context: js.Object = null
          ): Evented = js.native

}

/*      Layer Classes     */

@JSName("L.Layer")
class Layer(options: js.Object = null) extends Evented {

  def addLayer(layer: Layer): Map = js.native

  def addTo(map: mapbox.Map): Layer = js.native

  def hasLayer(layer: Layer): Boolean = js.native

  def removeLayer(layer: Layer): Map = js.native

}

@JSName("L.LayerGroup")
class LayerGroup(options: js.Object = null) extends Layer {

  def setZIndex(zIndex: Int): Layer = js.native

}

@JSName("L.Marker")
class Marker(latlng: js.Array[Double], options: js.Object = null
            ) extends Layer {

  def setZIndexOffset(offset: Int): Marker = js.native

}
@JSName("L.FeatureGroup")
class FeatureGroup(options: js.Object = null) extends LayerGroup {

  def setStyle(style: js.Object): FeatureGroup = js.native

}

@JSName("L.GeoJSON")
class GeoJSON(geoJsonFeature: js.Object = null, options: js.Object = null
             ) extends FeatureGroup {

  def resetStyle(layer: Layer): GeoJSON = js.native

  override
  def setStyle(style: js.Object): GeoJSON = js.native

}

@JSName("L.GridLayer")
class GridLayer(options: js.Object = null) extends Layer {

  def setZIndex(zIndex: Int): Layer = js.native

}

@JSName("L.TileLayer")
class TileLayer(options: js.Object = null) extends GridLayer {

}

@JSName("L.Popup")
class Popup(options: js.Object = null) extends Layer {

  def openOn(map: mapbox.Map): Popup = js.native

  def setLatLng(latlng: js.Array[Double]): Popup = js.native

  def setContent(content: String): Popup = js.native

  //
  var _map: mapbox.Map = js.native

}

@JSName("L.Path")
class Path(options: js.Object = null) extends Layer {

}

@JSName("L.CircleMarker")
class CircleMarker(latlng: js.Object,
                   options: js.Object = null
                  ) extends Path {

}


/*      Other  classes       */
@JSName("L.LatLngBounds")
class LatLngBounds() extends js.Object

@JSName("L.Control")
class Control extends Class {

  def addTo(map: mapbox.Map): Control = js.native

  //FIXME: what is a container, really?
  type Container = js.Object
  var onAdd: js.Function1[mapbox.Map, Container] = js.native
}

@JSName("L.Control.Attribution")
class ControlAttribution extends Control {
  def addAttribution(text: String): ControlAttribution = js.native
}

@JSName("L.DomUtil")
object DomUtil extends js.Object {
  def create(
              tagName: String,
              className: String,
              container: js.Object = null
              ): Element = js.native
}


object Helpers {
  implicit class PopupExtension(val self: Popup) extends AnyVal {
    def hasMap: Boolean = js.DynamicImplicits.truthValue(
      self._map.asInstanceOf[js.Dynamic]
    )

  }
}



/*     End Layer Classes    */

@JSName("L")
object L extends js.Object {
  def circleMarker(latlng: js.Object,
                   options: js.Object = null
                  ): GeoJSON = js.native


  def control(options: js.Object): Control = js.native

  def geoJson(geoJsonFeature: js.Object, options: js.Object = null): GeoJSON = js.native

  def tileLayer(urlTemplate: String, options: js.Object = null): TileLayer = js.native
}
