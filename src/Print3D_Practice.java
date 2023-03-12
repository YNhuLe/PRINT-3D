import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Print3D_Practice extends Application {

	public void start(Stage primaryStage) {
		boolean is3DSupported = Platform.isSupported(ConditionalFeature.SCENE3D);
		if (!is3DSupported) {
			System.out.println("Sorry, 3D is not supported in javaFX on this platform.");
			return;
		}
		Box box = new Box(250, 250, 250);

		box.setCullFace(CullFace.BACK);
		box.setTranslateX(250);
		box.setTranslateY(150);
		box.setTranslateZ(250);

		PerspectiveCamera camera = new PerspectiveCamera(false);
		camera.setTranslateX(10);
		camera.setTranslateY(-100);
		camera.setTranslateZ(250);

		Group root = new Group(box);

		PhongMaterial material = new PhongMaterial();

		material.setDiffuseMap(new Image(
				"https://th.bing.com/th/id/R.f7f160c4d53748cea7e2a29074ffb85b?rik=eYVvr1iFE%2fnOAg&riu=http%3a%2f%2fpluspng.com%2fimg-png%2fsunset-png-hd-sunset-sun-holiday-nature-tree-isolated-scenic-960.png&ehk=PzZq%2bw%2fD%2fEldcIHbAR4aEoor5wDDnoFGDjEnmDHoatY%3d&risl=&pid=ImgRaw&r=0"));

		box.setMaterial(material);

		Scene scene = new Scene(root, 500, 500, true);
		scene.setCamera(new PerspectiveCamera());
		scene.setCamera(camera);
		scene.setFill(Color.rgb(10, 20, 10, 0.5));
		primaryStage.setScene(scene);
		primaryStage.setTitle("3D Example");
		primaryStage.show();
		rotateAroundYAxis(box).play();

	}

	private RotateTransition rotateAroundYAxis(Node node) {
		RotateTransition rotate = new RotateTransition(Duration.seconds(20), node);
		rotate.setAxis(Rotate.Y_AXIS);
		rotate.setFromAngle(360);
		rotate.setToAngle(0);
		rotate.setInterpolator(Interpolator.LINEAR);
		rotate.setCycleCount(RotateTransition.INDEFINITE);

		return rotate;

	}

	public static void main(String[] args) {
		launch(args);
	}
}
