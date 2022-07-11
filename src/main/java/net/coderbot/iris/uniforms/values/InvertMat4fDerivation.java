package net.coderbot.iris.uniforms.values;

import net.coderbot.iris.vendored.joml.Matrix4f;

public class InvertMat4fDerivation {
	int srcHandle;
	int dstHandle;
	private final Matrix4f tmp = new Matrix4f();

	public void apply(UniformValues values) {
		values.loadMat4f(srcHandle, tmp);

		tmp.invert();

		values.storeMat4f(dstHandle, tmp);
	}

	@Override
	public String toString() {
		return "InvertMat4fDerivation{" +
			"srcHandle=" + srcHandle +
			", dstHandle=" + dstHandle +
			'}';
	}
}
