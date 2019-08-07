package com.ciuc.andrii.ar_test

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.Anchor
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.ViewRenderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val MIN_OPENGL_VERSION = 3.0

    private lateinit var arFragment: ArFragment
    private lateinit var bearRanderable: ModelRenderable
    private lateinit var catRanderable: ModelRenderable
    private lateinit var cowRanderable: ModelRenderable
    private lateinit var dogRanderable: ModelRenderable
    private lateinit var elephantRanderable: ModelRenderable
    private lateinit var ferrerRanderable: ModelRenderable
    private lateinit var hippopotamusRanderable: ModelRenderable
    private lateinit var horseRanderable: ModelRenderable
    private lateinit var koalaBearRanderable: ModelRenderable
    private lateinit var lionRanderable: ModelRenderable
    private lateinit var wolverineRanderable: ModelRenderable
    private lateinit var ironManRanderable: ModelRenderable
    private lateinit var dragonRanderable: ModelRenderable

    private var arrayView = listOf<ImageView>()


    private var selectedPosition = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!checkIsSupportedDeviceOrFinish(this)) {
            return
        }
        setContentView(R.layout.activity_main)

        arFragment = supportFragmentManager.findFragmentById(R.id.arView) as ArFragment

        arrayView = listOf<ImageView>(
            imageBear,
            imageCat,
            imageCow,
            imageDog,
            imageElephant,
            imageFerrer,
            imageHippopotamus,
            imageHorse,
            imageKoala,
            imageLion,
            imageWolverine,
            imageIronman,
            imageDragon
        )

        arrayView.forEach {
            it.setOnClickListener(this@MainActivity)
        }

        setBackground(imageBear.id)

        try {
            setupModel()

            arFragment.setOnTapArPlaneListener { hitResult, plane, motionEvent ->
                try {
                    val anchor: Anchor = hitResult.createAnchor()
                    val anchorNode: AnchorNode = AnchorNode(anchor)
                    anchorNode.setParent(arFragment.arSceneView.scene)

                    createModel(anchorNode, selectedPosition)
                } catch (e: Exception) {
                    Log.d("dvdd", e.toString())
                }

            }
        } catch (e: Exception) {
            Toast.makeText(this@MainActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupModel() {

        ModelRenderable.builder()
            .setSource(this, R.raw.bear)
            .build()
            .thenAccept { renderable -> bearRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.cat)
            .build()
            .thenAccept { renderable -> catRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.cow)
            .build()
            .thenAccept { renderable -> cowRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.dog)
            .build()
            .thenAccept { renderable -> dogRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.elephant)
            .build()
            .thenAccept { renderable -> elephantRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.ferret)
            .build()
            .thenAccept { renderable -> ferrerRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.hippopotamus)
            .build()
            .thenAccept { renderable -> hippopotamusRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.horse)
            .build()
            .thenAccept { renderable -> horseRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.lion)
            .build()
            .thenAccept { renderable -> lionRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.wolverine)
            .build()
            .thenAccept { renderable -> wolverineRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.ironman)
            .build()
            .thenAccept { renderable -> ironManRanderable = renderable }
            .exceptionally { null }

        ModelRenderable.builder()
            .setSource(this, R.raw.dragon2)
            .build()
            .thenAccept { renderable -> dragonRanderable = renderable }
            .exceptionally { null }

    }

    private fun createModel(anchorNode: AnchorNode, selectedPosition: Int) {
        when (selectedPosition) {
            1 -> {
                var Bear: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Bear.setParent(anchorNode)
                Bear.renderable = bearRanderable
                Bear.select()
                addLabel(anchorNode, Bear, "Bear")
            }
            2 -> {
                var Cat: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Cat.setParent(anchorNode)
                Cat.renderable = catRanderable
                Cat.select()
                addLabel(anchorNode, Cat, "Cat")
            }
            3 -> {
                var Cow: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Cow.setParent(anchorNode)
                Cow.renderable = cowRanderable
                Cow.select()
                addLabel(anchorNode, Cow, "Cow")
            }
            4 -> {
                var Dog: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Dog.setParent(anchorNode)
                Dog.renderable = dogRanderable
                Dog.select()
                addLabel(anchorNode, Dog, "Dog")
            }
            5 -> {
                var Elephant: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Elephant.setParent(anchorNode)
                Elephant.renderable = elephantRanderable
                Elephant.select()
                addLabel(anchorNode, Elephant, "Elephant")
            }
            6 -> {
                var Ferret: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Ferret.setParent(anchorNode)
                Ferret.renderable = ferrerRanderable
                Ferret.select()
                addLabel(anchorNode, Ferret, "Ferret")
            }
            7 -> {
                var Hippopotamus: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Hippopotamus.setParent(anchorNode)
                Hippopotamus.renderable = hippopotamusRanderable
                Hippopotamus.select()
                addLabel(anchorNode, Hippopotamus, "Hippopotamus")
            }
            8 -> {
                var Horse: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Horse.setParent(anchorNode)
                Horse.renderable = horseRanderable
                Horse.select()
                addLabel(anchorNode, Horse, "Horse")
            }
            9 -> {
                var Koala: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Koala.setParent(anchorNode)
                Koala.renderable = koalaBearRanderable
                Koala.select()
                addLabel(anchorNode, Koala, "Koala")
            }
            10 -> {
                var Lion: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Lion.setParent(anchorNode)
                Lion.renderable = lionRanderable
                Lion.select()
                addLabel(anchorNode, Lion, "Lion")
            }
            11 -> {
                var Wolverine: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Wolverine.setParent(anchorNode)
                Wolverine.renderable = wolverineRanderable
                Wolverine.select()
                addLabel(anchorNode, Wolverine, "Wolverine")
            }
            12 -> {
                var IronMan: TransformableNode = TransformableNode(arFragment.transformationSystem)
                IronMan.setParent(anchorNode)
                IronMan.renderable = ironManRanderable
                IronMan.select()
                addLabel(anchorNode, IronMan, "IronMan")
            }
            13 -> {
                var Dragon: TransformableNode = TransformableNode(arFragment.transformationSystem)
                Dragon.setParent(anchorNode)
                Dragon.renderable = dragonRanderable
                Dragon.select()
                addLabel(anchorNode, Dragon, "Dragon")
            }

        }
    }

    private fun addLabel(anchorNode: AnchorNode, model: TransformableNode, s: String) {

        ViewRenderable.builder()
            .setView(this, R.layout.animal_label)
            .build()
            .thenAccept { renderable ->

                var animalLabel: TransformableNode = TransformableNode(arFragment.transformationSystem)
                animalLabel.localPosition = Vector3(0f, model.localPosition.y + 0.5f, 0f)
                animalLabel.setParent(anchorNode)
                animalLabel.renderable = renderable
                animalLabel.select()

                val textView: TextView = renderable.view as TextView
                textView.text = s
                textView.setOnClickListener {
                    anchorNode.setParent(null)
                }
            }
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.imageBear -> selectedPosition = 1
            R.id.imageCat -> selectedPosition = 2
            R.id.imageCow -> selectedPosition = 3
            R.id.imageDog -> selectedPosition = 4
            R.id.imageElephant -> selectedPosition = 5
            R.id.imageFerrer -> selectedPosition = 6
            R.id.imageHippopotamus -> selectedPosition = 7
            R.id.imageHorse -> selectedPosition = 8
            R.id.imageKoala -> selectedPosition = 9
            R.id.imageLion -> selectedPosition = 10
            R.id.imageWolverine -> selectedPosition = 11
            R.id.imageIronman -> selectedPosition = 12
            R.id.imageDragon -> selectedPosition = 13
        }
        p0?.id?.let { setBackground(it) }
    }

    private fun setBackground(id: Int) {
        arrayView.forEach {
            if (it.id == id) {
                it.setBackgroundColor(resources.getColor(R.color.label_backg2))
            } else {
                it.setBackgroundColor(Color.TRANSPARENT)
            }
        }
    }

    fun checkIsSupportedDeviceOrFinish(activity: Activity): Boolean {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Toast.makeText(activity, "Sceneform requires Android N or later", Toast.LENGTH_LONG).show()
            activity.finish()
            return false
        }
        val openGlVersionString = (activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
            .deviceConfigurationInfo
            .glEsVersion
        if (java.lang.Double.parseDouble(openGlVersionString) < MIN_OPENGL_VERSION) {
            Toast.makeText(activity, "Sceneform requires OpenGL ES 3.0 or later", Toast.LENGTH_LONG)
                .show()
            activity.finish()
            return false
        }
        return true
    }
}
