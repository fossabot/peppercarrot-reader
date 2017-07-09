package nightlock.peppercarrot.viewholders

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.piasy.biv.view.BigImageView
import nightlock.peppercarrot.R

/**
 * ViewHolder that has a single ImageView for showing a comic page.
 * Created by nightlock on 5/7/17.
 */
class ComicViewHolder private constructor(v: View): RecyclerView.ViewHolder(v){
    val imageView : BigImageView =
            v.findViewById(R.id.comic_image) as BigImageView

    fun onBind(imgLink: String) = imageView.showImage(Uri.parse(imgLink))

    companion object {
        fun newInstance(viewGroup: ViewGroup) : ComicViewHolder {
            val view = LayoutInflater
                    .from(viewGroup.context)
                    .inflate(R.layout.fragment_comic_viewer, viewGroup, false)
            return ComicViewHolder(view)
        }
    }
}