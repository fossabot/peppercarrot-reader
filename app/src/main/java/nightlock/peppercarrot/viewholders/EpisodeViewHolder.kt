package nightlock.peppercarrot.viewholders

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import nightlock.peppercarrot.R

/**
 * Created by nightlock on 5/2/17.
 */

val ASPECT_RATIO = 992f/690f

class EpisodeViewHolder private constructor(v: View): RecyclerView.ViewHolder(v){
    init {
        val imageView = v.findViewById(R.id.episode_image)

        //Set dimension(Prevents view from collapsing while loading image from Glide in RecycleView.)
        imageView.layout(0, 0, 0, 0)
        private var layoutParams = imageView.layoutParams as PercentFrameLayout.LayoutParams
        layoutParams.percentLayoutInfo.aspectRatio = ASPECT_RATIO
        layoutParams.height = 0
        imageView.layoutParams=layoutParams
    }

    object Factory{
        fun newInstance(viewGroup: ViewGroup) : EpisodeViewHolder {
            val view = LayoutInflater
                    .from(viewGroup.context)
                    .inflate(R.layout.episode_card, viewGroup, false)
            return EpisodeViewHolder(view)
        }

    }

    fun onBind(imgLink: String) {
        Glide
            .with(imageView.context)
            .load(imgLink)
            .into(imageView)
    }
}
