package org.oscim.test;

import org.oscim.gdx.GdxMapApp;
import org.oscim.layers.tile.buildings.BuildingLayer;
import org.oscim.layers.tile.vector.VectorTileLayer;
import org.oscim.layers.tile.vector.labeling.LabelLayer;
import org.oscim.map.Map;
import org.oscim.theme.VtmThemes;
//import org.oscim.tiling.source.OkHttpEngine;
import org.oscim.tiling.source.UrlTileSource;
import org.oscim.tiling.source.mvt.MapboxVectorTileSource;

public class MapTest extends GdxMapApp {

	@Override
	public void createLayers() {
		Map map = getMap();

		//UrlTileSource tileSource = new OSciMap4TileSource("https://vector.mapzen.com/osm/all");

		//UrlTileSource tileSource = new HighroadJsonTileSource();

		UrlTileSource tileSource = new MapboxVectorTileSource("https://vector.mapzen.com/osm/all",
		                                                      "/{Z}/{X}/{Y}.mvt");

		//UrlTileSource tileSource = new MapboxVectorTileSource("http://localhost:8080/water",
		//                                                      "/{Z}/{X}/{Y}.mvt");
		//tileSource.setHttpEngine(new OkHttpEngine.OkHttpFactory());

		VectorTileLayer l = map.setBaseMap(tileSource);

		map.layers().add(new BuildingLayer(map, l));
		map.layers().add(new LabelLayer(map, l));

		map.setTheme(VtmThemes.MAPZEN);
		//map.setTheme(new DebugTheme());

		//map.setMapPosition(53.075, 8.808, 1 << 17);
	}

	public static void main(String[] args) {
		GdxMapApp.init();
		GdxMapApp.run(new MapTest(), null, 400);
	}
}
