package com.inter.trunks.demofestapp.map

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.ui.fragment.BaseFragment
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.map.di.MAP_VM
import com.inter.trunks.demofestapp.map.vm.MapFragmentVM
import org.koin.androidx.viewmodel.ext.android.viewModel

class MapFragment : BaseFragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun getLayoutResources(): Int = R.layout.fragment_maps
    val vm: MapFragmentVM by viewModel(name = MAP_VM)
    override fun initialize() {
        var mapFragment: SupportMapFragment = SupportMapFragment.newInstance()
        activity!!.supportFragmentManager.beginTransaction().replace(R.id.map, mapFragment).commit();
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.uiSettings.isScrollGesturesEnabled = false;
        LogUtil.printLog("MapFragment", "key  map " + getString(R.string.google_maps_key))
        setEventPoints()
    }

    fun setEventPoints() {
        vm.loadPoinst({
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(it[0].position, 16F))
            for (markerOptions in it) {
                mMap.addMarker(markerOptions)
            }
        }
            , context!!)
    }
}