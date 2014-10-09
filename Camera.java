package Display;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Camera {
	private float x;
	private float y;
	private float z;
	private float rx;
	private float ry;
	private float rz;
	private float fov;
	private float aspect;
	private float nearClippingPlane;
	private float farClippingPlane;

	public Camera(float fov, float aspect, float nearClippingPlane,
			float FarClippingPlane) {
		x = 0;
		y = 0;
		z = 0;
		rx = 0;
		ry = 0;
		rz = 0;
		this.fov = fov;
		this.aspect = aspect;
		this.nearClippingPlane = nearClippingPlane;
		this.farClippingPlane = farClippingPlane;
		initProjection();
	}

	private void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, aspect, nearClippingPlane, farClippingPlane);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_DEPTH_TEST);
	}

	public void setView() {
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);
		glTranslatef(x, y, z);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getRX() {
		return rx;
	}

	public float getRY() {
		return ry;
	}

	public float getRZ() {
		return rz;
	}

	public void setRX(float rx) {
		this.rx = rx;
	}

	public void setRY(float ry) {
		this.ry = ry;
	}

	public void setRZ(float rz) {
		this.rz = rz;
	}

	public void MoveDirection(float dir, float amt) {
		z += amt * Math.sin(Math.toRadians(ry + 90 * dir));
		x += amt * Math.cos(Math.toRadians(ry + 90 * dir));
	}									

	public void RotateY(float amt) {
		ry += amt;
	}
	public void RotateX(float amt) {
		rx += amt;
	}
}
