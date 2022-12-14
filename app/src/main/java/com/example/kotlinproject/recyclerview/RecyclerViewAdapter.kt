package com.example.kotlinproject.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.ItemFoodsBinding
import com.example.kotlinproject.db.entity.Foods
import com.example.kotlinproject.enum.FoodNames.Companion.BIBIM_BAP
import com.example.kotlinproject.enum.FoodNames.Companion.BUCHIM_GAE
import com.example.kotlinproject.enum.FoodNames.Companion.CHEONGGUCK_JANG
import com.example.kotlinproject.enum.FoodNames.Companion.CHICKEN
import com.example.kotlinproject.enum.FoodNames.Companion.DAK_BAL
import com.example.kotlinproject.enum.FoodNames.Companion.DDEK_BOKKI
import com.example.kotlinproject.enum.FoodNames.Companion.DOEN_JANG_JJIGAE
import com.example.kotlinproject.enum.FoodNames.Companion.DON_GAS
import com.example.kotlinproject.enum.FoodNames.Companion.DO_SI_RAK
import com.example.kotlinproject.enum.FoodNames.Companion.GALBITANG
import com.example.kotlinproject.enum.FoodNames.Companion.GIM_BAP
import com.example.kotlinproject.enum.FoodNames.Companion.GOB_CHANG
import com.example.kotlinproject.enum.FoodNames.Companion.GUG_BAB
import com.example.kotlinproject.enum.FoodNames.Companion.HAEJANG_GUG
import com.example.kotlinproject.enum.FoodNames.Companion.HAMBURGER
import com.example.kotlinproject.enum.FoodNames.Companion.HOTDOG
import com.example.kotlinproject.enum.FoodNames.Companion.JAJJANG
import com.example.kotlinproject.enum.FoodNames.Companion.JEYUGBOKK_EUM
import com.example.kotlinproject.enum.FoodNames.Companion.JJAMBONG
import com.example.kotlinproject.enum.FoodNames.Companion.JUKKUMI
import com.example.kotlinproject.enum.FoodNames.Companion.KALGUGSU
import com.example.kotlinproject.enum.FoodNames.Companion.MAN_DO
import com.example.kotlinproject.enum.FoodNames.Companion.MARA_TANG
import com.example.kotlinproject.enum.FoodNames.Companion.OMURICE
import com.example.kotlinproject.enum.FoodNames.Companion.PASTA
import com.example.kotlinproject.enum.FoodNames.Companion.PIZZA
import com.example.kotlinproject.enum.FoodNames.Companion.RAMEN
import com.example.kotlinproject.enum.FoodNames.Companion.SAM_GYEOB_SAL
import com.example.kotlinproject.enum.FoodNames.Companion.SAM_GYE_TANG
import com.example.kotlinproject.enum.FoodNames.Companion.SANDWICH
import com.example.kotlinproject.enum.FoodNames.Companion.SASHIMI
import com.example.kotlinproject.enum.FoodNames.Companion.SOYED_CRAB
import com.example.kotlinproject.enum.FoodNames.Companion.SSAL_GUKSU
import com.example.kotlinproject.enum.FoodNames.Companion.SUNDAEBOKK
import com.example.kotlinproject.enum.FoodNames.Companion.YANG_KKO_CHI
import com.example.kotlinproject.enum.FoodNames.Companion.YUG_HOE

class RecyclerViewAdapter(val foodList : LiveData<ArrayList<Foods>>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()  {

    interface ItemClickListener {
        fun onDeleteClick(position: Int)
    }

    private lateinit var mListener : ItemClickListener

    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.mListener = itemClickListener
    }

    override fun getItemCount(): Int {
        // ??????????????? ?????? ????????? ???????????? ???????????? ????????? !!???????????? ???????????? ????????? ??????
        val size = foodList.value?.size ?: 0
        return size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemFoodsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        foodList.value?.let {
            holder.bind(it[position])
        }
    }

    /**
     * ViewHolder
     */
    inner class ViewHolder(private val binding: ItemFoodsBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(foods: Foods) {
            binding.imvFood.setImageResource(when(foods.name){
                BIBIM_BAP -> R.drawable.select_bibim_bap
                BUCHIM_GAE -> R.drawable.select_buchim_gae
                CHEONGGUCK_JANG -> R.drawable.select_cheong_guk_jang
                DAK_BAL -> R.drawable.select_dak_bal
                CHICKEN -> R.drawable.select_chicken
                DDEK_BOKKI -> R.drawable.select_ddek_bokki
                DO_SI_RAK -> R.drawable.select_do_si_rak
                DOEN_JANG_JJIGAE -> R.drawable.select_doen_jang_jjigae
                DON_GAS -> R.drawable.select_don_gas
                GALBITANG -> R.drawable.select_galbitang

                GIM_BAP -> R.drawable.select_gim_bap
                GOB_CHANG -> R.drawable.select_gob_chang
                GUG_BAB -> R.drawable.select_gug_bab
                HAEJANG_GUG -> R.drawable.select_haejang_gug
                HAMBURGER -> R.drawable.main_hamburger
                HOTDOG -> R.drawable.select_hotdog
                JAJJANG -> R.drawable.select_jajjang
                JEYUGBOKK_EUM -> R.drawable.select_jeyugbokk_eum
                JJAMBONG -> R.drawable.select_jjambong
                JUKKUMI -> R.drawable.select_jukkumi
                KALGUGSU -> R.drawable.select_kalgugsu
                MAN_DO -> R.drawable.select_man_do
                MARA_TANG -> R.drawable.select_mara_tang
                OMURICE -> R.drawable.select_omurice
                PASTA -> R.drawable.select_pasta
                PIZZA -> R.drawable.select_pizza
                RAMEN -> R.drawable.select_ramen
                SAM_GYE_TANG -> R.drawable.select_sam_gye_tang
                SAM_GYEOB_SAL -> R.drawable.select_sam_gyeob_sal
                SANDWICH -> R.drawable.select_sandwich

                SASHIMI -> R.drawable.select_sashimi
                SOYED_CRAB -> R.drawable.select_soyed_crab
                SSAL_GUKSU -> R.drawable.select_ssal_guksu

                SUNDAEBOKK -> R.drawable.select_sundaebokk_eum
                YANG_KKO_CHI -> R.drawable.select_yang_kko_chi

                else -> R.drawable.select_yug_hoe
            })


            binding.txtFood.text = when(foods.name) {
                BIBIM_BAP -> "?????????"
                BUCHIM_GAE -> "?????????"
                CHEONGGUCK_JANG -> "?????????"
                DAK_BAL -> "??????"
                CHICKEN -> "??????"
                DDEK_BOKKI -> "?????????"
                DO_SI_RAK -> "?????????"
                DOEN_JANG_JJIGAE -> "????????????"
                DON_GAS -> "?????????"
                GALBITANG -> "?????????"
                GIM_BAP -> "??????"
                GOB_CHANG -> "??????"
                GUG_BAB -> "??????"
                HAEJANG_GUG -> "?????????"
                HAMBURGER -> "?????????"
                HOTDOG -> "?????????"
                JAJJANG -> "?????????"
                JEYUGBOKK_EUM -> "????????????"
                JJAMBONG -> "??????"
                JUKKUMI -> "?????????"
                KALGUGSU -> "?????????"
                MAN_DO -> "??????"
                MARA_TANG -> "?????????"
                OMURICE -> "???????????????"
                PASTA -> "?????????"
                PIZZA -> "??????"
                RAMEN -> "??????"
                SAM_GYE_TANG -> "?????????"
                SAM_GYEOB_SAL -> "?????????"
                SANDWICH -> "????????????"
                SASHIMI -> "?????????"
                SOYED_CRAB -> "????????????"
                SSAL_GUKSU -> "?????????"
                SUNDAEBOKK -> "????????????"
                YANG_KKO_CHI -> "?????????"
                else -> "??????"
            }
            binding.txtDate.text = foods.date
            binding.cdvDelete.setOnClickListener {
                /**
                 * interface ?????? ??????
                 */
                mListener.onDeleteClick(adapterPosition)
            }
        }

    }
}