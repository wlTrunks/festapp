package com.inter.trunks.demofestapp.map.vm

import android.annotation.SuppressLint
import android.content.Context
import com.inter.trunks.demofestapp.base.vm.BaseViewModel
import com.inter.trunks.demofestapp.map.repository.GetEventPoints
import org.koin.standalone.inject
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.inter.trunks.demofestapp.R
import com.inter.trunks.demofestapp.base.util.LogUtil
import com.inter.trunks.demofestapp.map.model.EventPoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.core.content.res.ResourcesCompat
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import com.google.android.gms.maps.model.BitmapDescriptor


class MapFragmentVM : BaseViewModel() {
    val repository: GetEventPoints by inject()

    @SuppressLint("CheckResult")
    fun loadPoinst(onLoaded: (List<MarkerOptions>) -> Unit, context: Context) {
        Observable.fromIterable(repository.loadEventPoint(2))
            .map(object : Function<EventPoint, MarkerOptions> {
                override fun apply(t: EventPoint): MarkerOptions {
                    LogUtil.printLog("MapFragmentVM", "EventPoint title " + t.title)
                    return MarkerOptions()
                        .position(LatLng(t.latitude, t.longtitude))
                        .title(t.title)
                        .icon(
                            getBitmapFromVector(context, R.drawable.ic_event_beacon)
                        )
                }
            })
            .toList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Consumer<List<MarkerOptions>> {
                override fun accept(t: List<MarkerOptions>) {
                    LogUtil.printLog("MapFragmentVM", "EventPoint title size " + t.size)
                    onLoaded.invoke(t)
                }
            })
    }

    fun getBitmapFromVector(
        @NonNull context: Context,
        @DrawableRes vectorResourceId: Int
//        @ColorInt tintColor: Int
    ): BitmapDescriptor {

        val vectorDrawable = ResourcesCompat.getDrawable(
            context.getResources(), vectorResourceId, null
        )
        if (vectorDrawable == null) {
            return BitmapDescriptorFactory.defaultMarker()
        }
        val bitmap = Bitmap.createBitmap(
            vectorDrawable.intrinsicWidth,
            vectorDrawable.intrinsicHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        vectorDrawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
//        DrawableCompat.setTint(vectorDrawable, tintColor)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}